# Sergio Acosta - Bounce Ball Simulator

## Description

The Bounce Ball Simulator is a Java-based graphical application that simulates bouncing balls with physical properties such as gravity, elasticity, and velocity. The application allows user interaction through dragging and dropping balls within the simulation.

## Features

- **Physics Simulation**: Simulates realistic ball movements using gravity, velocity, and bounce coefficients.
- **Interactive UI**: Drag and drop balls in real time.
- **Customizable**: Add new balls with different properties.
- **Color-coded Balls**: Easily identify balls using their assigned colors.

## Directory Structure

```
sergioacostater-bounce-ball-simulator/
├── README.md
├── simulator.iml
└── src/
    └── software/
        └── ulpgc/
            ├── model/
            │   ├── Ball.java
            │   └── BallColor.java
            ├── view/
            │   ├── MainFrame.java
            │   ├── SwingBallDisplay.java
            │   └── BallDisplay.java
            ├── controller/
            │   └── BallPresenter.java
            └── service/
                └── BallSimulator.java
```

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/SergioAcostaTer/bounce-ball-simulator.git
   cd sergioacostater-bounce-ball-simulator
   ```

2. Open the project in IntelliJ IDEA or any Java IDE of your choice.

3. Build the project to resolve dependencies and compile the code.

## Usage

1. Run the `Main` class from your IDE or using the command line:
   ```bash
   java -cp <compiled_classes_directory> software.ulpgc.Main
   ```

2. Interact with the simulation by dragging and dropping balls in the UI.

3. Add new balls with custom properties by modifying the `Main` class:
   ```java
   BallPresenter presenter = new BallPresenter(mainFrame.getBallDisplay(), new BallSimulator(0.001))
       .add(new Ball("6", 15, 1.0, 20, 0, -9.8, 0.75));
   ```

## Project Structure and Code Details

- **Ball.java**: Defines the `Ball` record with properties like position, velocity, and bounce coefficient.
- **BallColor.java**: Enum mapping IDs to `java.awt.Color` for ball visualization.
- **BallDisplay.java**: Interface for displaying and interacting with balls.
- **BallPresenter.java**: Manages ball simulation and interaction.
- **BallSimulator.java**: Calculates new ball states based on physics equations.
- **Main.java**: Entry point for initializing and running the simulator.
- **MainFrame.java**: Creates the graphical frame and hosts the simulation UI.
- **SwingBallDisplay.java**: Implements the `BallDisplay` interface using Swing for UI rendering.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m 'Add feature-name'`.
4. Push to the branch: `git push origin feature-name`.
5. Open a pull request.

## License

This project is licensed under the MIT License. See `LICENSE` for more information.

## Contact

For questions or feedback, please contact Sergio Acosta.
