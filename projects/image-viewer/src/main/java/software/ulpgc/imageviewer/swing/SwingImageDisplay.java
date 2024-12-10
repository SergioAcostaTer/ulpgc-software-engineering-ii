package software.ulpgc.imageviewer.swing;

import software.ulpgc.imageviewer.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private static final int SLIDE_SENSITIVITY = 3;
    private int currentIndex = 0;
    private int dragOffset = 0;
    private int lastDragX = 0;
    private boolean isAnimating = false;
    private final List<Paint> paints = new ArrayList<>();
    private final Map<String, Image> images;
    private Timer animationTimer;
    private int animationStep;
    private int animationTargetOffset;

    public SwingImageDisplay(Map<String, String> imagePaths) {
        this.images = loadImages(imagePaths);
        this.addMouseListener(createMouseListener());
        this.addMouseMotionListener(createMouseMotionListener());
    }



    private Map<String, Image> loadImages(Map<String, String> imagePaths) {
        return imagePaths.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new ImageIcon(entry.getValue()).getImage()
                ));
    }

    private MouseListener createMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isAnimating) return;
                stopAnimationIfRunning();
                lastDragX = e.getX();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isAnimating) return;
                handleMouseRelease();
            }
        };
    }

    private MouseMotionListener createMouseMotionListener() {
        return new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isAnimating) return;
                dragOffset = e.getX() - lastDragX;
                repaint();
            }
        };
    }

    private void stopAnimationIfRunning() {
        if (animationTimer != null && animationTimer.isRunning()) {
            animationTimer.stop();
        }
    }

    private void handleMouseRelease() {
        int threshold = getWidth() / SLIDE_SENSITIVITY;
        if (Math.abs(dragOffset) > threshold) {
            startAnimation(dragOffset < 0 ? -getWidth() : getWidth());
        } else {
            startAnimation(0);
        }
    }

    private void startAnimation(int targetOffset) {
        isAnimating = true;
        animationTargetOffset = targetOffset;
        animationStep = (targetOffset - dragOffset) / 20;

        stopAnimationIfRunning();

        animationTimer = new Timer(8, e -> {
            dragOffset += animationStep;
            if (hasAnimationReachedTarget()) {
                finalizeAnimation();
                ((Timer) e.getSource()).stop();
                isAnimating = false;
            }
            repaint();
        });

        animationTimer.start();
    }

    private boolean hasAnimationReachedTarget() {
        return (animationStep > 0 && dragOffset >= animationTargetOffset) ||
                (animationStep < 0 && dragOffset <= animationTargetOffset);
    }

    private void finalizeAnimation() {
        dragOffset = animationTargetOffset;
        if (dragOffset == -getWidth()) {
            currentIndex = (currentIndex + 1) % paints.size();
        } else if (dragOffset == getWidth()) {
            currentIndex = (currentIndex - 1 + paints.size()) % paints.size();
        }
        dragOffset = 0;
        repaint();
    }

    @Override
    public void paint(String id, int offset) {
        if ("next".equals(id)) {
            currentIndex = (currentIndex + 1) % paints.size();
        } else if ("previous".equals(id)) {
            currentIndex = (currentIndex - 1 + paints.size()) % paints.size();
        } else {
            paints.add(new Paint(id, offset));
        }
        repaint();
    }


    @Override
    public void clear() {
        paints.clear();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int panelWidth = getWidth();
        int xOffset = dragOffset;

        for (int i = -1; i <= 1; i++) {
            int index = (currentIndex + i + paints.size()) % paints.size();
            Image image = images.get(paints.get(index).id);
            if (image != null) {
                int xPosition = (i * panelWidth) + xOffset;
                g2d.drawImage(image, xPosition, 0, panelWidth, getHeight(), this);
            }
        }

        drawAdditionalImages(g2d, panelWidth, xOffset);
    }

    private void drawAdditionalImages(Graphics2D g2d, int panelWidth, int xOffset) {
        if (dragOffset > panelWidth && paints.size() > 2) {
            drawImageAtOffset(g2d, panelWidth, xOffset, -2);
        } else if (dragOffset < -panelWidth && paints.size() > 2) {
            drawImageAtOffset(g2d, panelWidth, xOffset, 2);
        }
    }

    private void drawImageAtOffset(Graphics2D g2d, int panelWidth, int xOffset, int positionMultiplier) {
        int index = (currentIndex + positionMultiplier + paints.size()) % paints.size();
        Image image = images.get(paints.get(index).id);
        if (image != null) {
            int xPosition = panelWidth * positionMultiplier + xOffset;
            g2d.drawImage(image, xPosition, 0, panelWidth, getHeight(), this);
        }
    }

    private record Paint(String id, int offset) {}
}
