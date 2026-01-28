# ULPGC Software Engineering II - Java Projects

[![Java](https://img.shields.io/badge/Java-17+-orange?logo=java)](https://www.java.com/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-blue?logo=apache-maven)](https://maven.apache.org/)
[![Spring](https://img.shields.io/badge/Spring_Boot-3.4.0-green?logo=spring)](https://spring.io/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> **Software Engineering II coursework** — Universidad de Las Palmas de Gran Canaria  
> Progressive learning path from IntelliJ automation to advanced design patterns, GUI applications, and physical simulations

---

## 📚 Table of Contents

- [Overview](#-overview)
- [Learning Path](#-learning-path)
- [Projects by Category](#-projects-by-category)
  - [Katas (1-7)](#-katas-foundational-exercises)
  - [Full Applications](#-full-applications)
  - [Simulations](#-simulations)
- [Technologies Used](#-technologies-used)
- [Quick Start](#-quick-start)
- [Project Details](#-project-details)
- [Key Concepts Demonstrated](#-key-concepts-demonstrated)
- [Academic Context](#-academic-context)
- [Contributing](#-contributing)
- [License](#-license)
- [Author](#-author)

---

## 🌟 Overview

This repository contains a comprehensive collection of Java projects demonstrating progressive mastery of:

- **Object-Oriented Programming** principles
- **Design Patterns** (Adapter, Command, Factory, MVC)
- **GUI Development** with Swing and JavaFX
- **Data Processing** and visualization
- **RESTful APIs** with Spring Boot
- **Physical Simulations** using numerical methods
- **Software Architecture** best practices

All projects emphasize clean code, SOLID principles, and professional software development workflows.

---

## 📈 Learning Path

```
Kata 1: IntelliJ Automation & Git
    ↓
Kata 2: File Processing & Data Analysis
    ↓
Kata 3: Data Visualization (JFreeChart)
    ↓
Kata 4: Database Integration (SQLite)
    ↓
Kata 5: API Consumption & Adapter Pattern
    ↓
Kata 6: RESTful API Development (Spring Boot)
    ↓
Kata 7: Desktop Application Packaging (.exe)
    ↓
Projects: Advanced GUI & Real-world Applications
    ↓
Simulations: Physics-based Interactive Systems
```

---

## 📁 Projects by Category

### 🎯 Katas: Foundational Exercises

#### **Kata 1: IntelliJ Automation & Git Workflow**
**Objective**: Master IntelliJ IDEA keyboard shortcuts and Git fundamentals

- ✅ Project creation and configuration
- ✅ Keyboard-driven development workflow
- ✅ Git version control best practices
- ✅ Commit hygiene and history management

**Tech**: IntelliJ IDEA, Git, Java 17+

[**→ Details**](katas/kata-1/README.md)

---

#### **Kata 2: IMDB Dataset Analysis**
**Objective**: Load, process, and analyze large datasets in memory

**Features**:
- TSV file parsing with custom deserializer
- Object-oriented data representation (`Title` class)
- Statistical analysis (duration distribution)
- Console-based histogram visualization

**Tech**: Java I/O, Collections, Stream API

**Sample Output**:
```
0-30    -> 9,630,674
31-60   -> 971,301
61-90   -> 330,828
91-120  -> 242,289
121-150 -> 60,651
+150    -> 54,921
```

[**→ Details**](katas/kata-2/README.md)

---

#### **Kata 3: Data Visualization with JFreeChart**
**Objective**: Extend Kata 2 with professional chart generation

**New Capabilities**:
- Bar chart generation with JFreeChart
- Swing-based GUI (MainFrame)
- Command pattern for zoom reset
- Interactive chart manipulation

**Tech**: Maven, JFreeChart 1.5.5, Swing

**Architecture**:
```
architecture/
├── charts/           # Barchart model & display interface
├── io/              # Data loading & commands
└── deserializer/    # TSV parsing
```

[**→ Details**](katas/kata-3/README.md)

---

#### **Kata 4: SQLite Database Integration**
**Objective**: Replace file-based data with SQL database

**Enhancements**:
- SQLite JDBC driver integration
- Repository pattern (`TitleLoaderDb`)
- SQL query construction
- Persistent data storage

**Tech**: Maven, SQLite JDBC 3.47.1.0, JFreeChart

**Database Schema**:
```sql
CREATE TABLE titles (
    primaryTitle TEXT,
    startYear INTEGER,
    runtimeMinutes INTEGER
);
```

[**→ Details**](katas/kata-4/README.md)

---

#### **Kata 5: Rick and Morty API Client**
**Objective**: Consume external APIs using Adapter pattern

**Features**:
- RESTful API consumption (Rick and Morty)
- JSON deserialization with Gson
- HTTP requests with JSoup
- Clean architecture (Reader → Deserializer → Adapter)

**Tech**: Maven, Gson 2.10.1, JSoup 1.15.4

**API Integration**:
```java
CharacterLoader loader = new CharacterLoader(
    new CharacterApiReader(),
    new CharacterJsonDeserializer(),
    new CharacterApiAdapter()
);
Character character = loader.get(); // Fetch character from API
```

[**→ Details**](katas/kata-5/README.md)

---

#### **Kata 6: Password Generator API (Spring Boot)**
**Objective**: Build production-ready RESTful service

**Features**:
- Spring Boot REST API
- Command pattern for business logic
- Request/Response adapters
- Factory pattern for command routing
- Query parameter handling

**Tech**: Spring Boot 3.4.0, Maven

**API Endpoints**:
```http
GET /api/password?length=12&special=1
```

**Response**:
```json
{
  "password": "Xy7!@hGd92qZ"
}
```

**Architecture Highlights**:
- `CommandController`: HTTP request handler
- `CommandFactory`: Maps paths to commands
- `CustomPasswordCommand`: Password generation logic
- `SpringRequestAdapter`: Query param extraction
- `SpringResponseAdapter`: JSON response builder

[**→ Details**](katas/kata-6/README.md)

---

#### **Kata 7: Currency Converter Desktop App**
**Objective**: Package Java application as Windows executable

**Features**:
- Currency conversion with live exchange rates
- Swing GUI with dropdowns and history panel
- Command pattern for conversion operations
- JPackage for `.exe` installer creation

**Tech**: Maven, Gson, JavaFX 17, JPackage

**Installation**:
```bash
mvn clean package
# Generates .exe installer in target/installer/
```

**GUI Components**:
- `InputPanel`: Conversion form
- `HistoryPanel`: Scrollable conversion log
- `MainApp`: Application entry point

[**→ Details**](katas/kata-7/README.md)

---

### 🚀 Full Applications

#### **Image Viewer**
**Advanced GUI with gesture-based navigation**

**Features**:
- Drag-and-drop image navigation
- Smooth slide animations
- Autoplay with timer
- Command pattern for controls
- Circular image buffer

**Tech**: Java Swing, MVC architecture

**Interaction**:
- Drag left/right to navigate
- "Autoplay" button for slideshow
- "Previous"/"Next" buttons

**Key Classes**:
- `SwingImageDisplay`: Canvas with mouse listeners
- `NextImageCommand`, `PreviousImageCommand`: Navigation
- `AutoplayCommand`: Timed slideshow
- `PendulumPresenter`: Coordinates model-view updates

[**→ Details**](projects/image-viewer/)

---

#### **Money Calculator**
**Professional currency converter with real-time rates**

**Features**:
- Real-time exchange rates (fxratesapi.com)
- 150+ currencies supported
- Scrollable conversion history
- Gson for JSON parsing
- Material Design-inspired UI

**Tech**: Maven, Gson 2.8.9, Java Swing

**Architecture**:
```
commands/
├── ExchangeCommand     # Conversion logic
└── CommandHistory      # Maintains log
service/
├── CurrencyRateService # Fetches rates
└── MoneyConverter      # Performs calculation
gui/
├── InputPanel          # User input form
└── HistoryPanel        # Conversion log display
```

[**→ Details**](projects/money-calculator/)

---

### 🎮 Simulations

#### **Bounce Ball Simulator**
**Physics-based ball simulation with gravity**

**Features**:
- Realistic physics (gravity, velocity, elasticity)
- Interactive drag-and-drop
- Multiple balls with color-coding
- Collision detection
- Coefficient of restitution (energy loss)

**Tech**: Java Swing, Numerical integration

**Physics Implementation**:
```java
// Velocity update with gravity
newVelocity = v + g * dt;

// Bounce velocity with energy loss
vBounce = -cr * v;

// Height calculation
h = h + v * dt + 0.5 * g * dt²;
```

**Key Classes**:
- `Ball`: Record with physics properties
- `BallSimulator`: Physics calculations
- `BallPresenter`: Coordinates simulation
- `SwingBallDisplay`: Renders balls

[**→ Details**](simulations/bounce-ball-simulator/)

---

#### **Pendulum Simulator**
**Interactive pendulum with Runge-Kutta integration**

**Features**:
- Accurate motion using RK4 method
- Real-time drag interaction
- Dynamic rope length adjustment
- JFreeChart data visualization
- Energy conservation modeling

**Tech**: Maven, JFreeChart 1.5.3, Swing

**Numerical Method (Runge-Kutta 4th Order)**:
```java
// k1: Initial slope
k1θ = dt * ω
k1ω = dt * (g/L) * sin(θ)

// k2, k3, k4: Intermediate slopes
// Final update:
θ_new = θ + (k1θ + 2k2θ + 2k3θ + k4θ) / 6
ω_new = ω + (k1ω + 2k2ω + 2k3ω + k4ω) / 6
```

**Key Classes**:
- `Pendulum`: State record (L, θ, ω, g)
- `PendulumSimulator`: RK4 integration
- `PendulumPresenter`: Updates view
- `SwingPendulumDisplay`: Interactive canvas
- `PendulumGraph`: JFreeChart visualization

[**→ Details**](simulations/pendulum-simulator/)

---

## 🛠️ Technologies Used

### Core Languages & Build Tools
- **Java**: 17+ (Records, Pattern Matching, Modern APIs)
- **Maven**: 3.8+ (Dependency management, build lifecycle)

### Frameworks & Libraries
- **Spring Boot**: 3.4.0 (REST APIs, DI, auto-configuration)
- **JFreeChart**: 1.5.5 (Data visualization, charts)
- **JavaFX**: 17 (Modern GUI framework)
- **Gson**: 2.10.1 (JSON serialization/deserialization)
- **JSoup**: 1.15.4 (HTTP client, HTML parsing)
- **SQLite JDBC**: 3.47.1.0 (Embedded database)

### GUI Frameworks
- **Swing**: Classic desktop UI (JFrame, JPanel, event listeners)
- **JavaFX**: Modern UI with CSS styling

### Design Patterns
- **MVC**: Model-View-Controller (all GUI projects)
- **Command**: Encapsulates actions (Kata 6, Image Viewer)
- **Adapter**: Interface translation (Kata 5, Kata 6)
- **Factory**: Object creation (Kata 6)
- **Repository**: Data access abstraction (Kata 4)

---

## ⚡ Quick Start

### Prerequisites
```bash
# Java Development Kit 17+
java -version

# Maven 3.8+
mvn -version

# IntelliJ IDEA (recommended) or any Java IDE
```

### Clone Repository
```bash
git clone https://github.com/yourusername/ulpgc-software-engineering-ii.git
cd ulpgc-software-engineering-ii
```

### Build & Run Examples

**Simple Kata (Kata 1-2)**:
```bash
cd katas/kata-2
javac -d bin src/software/ulpgc/kata2/*.java
java -cp bin software.ulpgc.kata2.Main
```

**Maven-based Projects (Kata 3-7, Projects, Simulations)**:
```bash
cd katas/kata-3
mvn clean install
mvn exec:java -Dexec.mainClass="software.ulpgc.kata3.windows.Main"
```

**Spring Boot API (Kata 6)**:
```bash
cd katas/kata-6
mvn spring-boot:run
# API available at http://localhost:8080/api/password
```

**Desktop Application (Kata 7)**:
```bash
cd katas/kata-7
mvn clean package
# Run generated .exe from target/installer/
```

---

## 📖 Project Details

### Common Architecture Patterns

#### **Layered Architecture** (Most Projects)
```
├── model/          # Domain entities (POJOs, Records)
├── view/           # UI components (Swing, JavaFX)
├── controller/     # Business logic, coordinators
├── service/        # External integrations
└── architecture/   # Interfaces, abstractions
```

#### **Clean Architecture** (Kata 5-6)
```
├── architecture/
│   ├── io/         # Input/Output adapters
│   ├── model/      # Core domain
│   └── contracts/  # API contracts
├── impl/           # Concrete implementations
└── adapter/        # Framework adapters
```

### Code Quality Standards

**All projects follow**:
- ✅ SOLID principles
- ✅ Clean Code practices (meaningful names, small methods)
- ✅ Separation of concerns
- ✅ Immutability where possible (Records)
- ✅ Proper exception handling
- ✅ Code reusability (interfaces, generics)

**Example: Record Usage** (Modern Java)
```java
// Immutable data structure (Kata 2-7, Simulations)
public record Title(String title, int year, int duration) {
    public String getRange() {
        if (duration <= 30) return "0-30";
        // ... categorization logic
    }
}
```

**Example: Command Pattern** (Kata 6, Image Viewer)
```java
public interface Command {
    void execute();
}

public class NextImageCommand implements Command {
    private final ImageDisplay display;
    
    public void execute() {
        display.paint("next", 0);
    }
}
```

---

## 💡 Key Concepts Demonstrated

### 1. **Object-Oriented Design**
- Encapsulation (`Ball`, `Pendulum`, `Title`)
- Inheritance (display interfaces)
- Polymorphism (command pattern implementations)
- Abstraction (service interfaces)

### 2. **Design Patterns**
- **MVC**: Clear separation in all GUI apps
- **Command**: Action encapsulation (Kata 6, Image Viewer)
- **Adapter**: Interface translation (Kata 5, Kata 6)
- **Factory**: Centralized object creation (Kata 6)
- **Repository**: Data access layer (Kata 4)

### 3. **Software Architecture**
- Layered architecture (presentation, business, data)
- Dependency injection (Spring Boot)
- Interface-based design (testability)
- Separation of concerns

### 4. **Data Structures & Algorithms**
- Collections (List, Map, Set)
- Stream API (functional programming)
- File I/O (BufferedReader, FileReader)
- Numerical methods (RK4, Euler integration)

### 5. **GUI Development**
- Event-driven programming (listeners)
- Custom painting (Graphics2D)
- Layout managers (BorderLayout, GridBagLayout)
- Animation (Timer, repaint cycles)

### 6. **API Development**
- RESTful endpoints (Spring Boot)
- JSON serialization/deserialization
- HTTP request/response handling
- Error handling & status codes

### 7. **Physics Simulations**
- Numerical integration (Runge-Kutta, Euler)
- Differential equations
- Collision detection
- Energy conservation

---

## 🎓 Academic Context

### Course: Software Engineering II
**Institution**: Universidad de Las Palmas de Gran Canaria  
**Academic Year**: 2024-2025  
**Credits**: Progressive skill-building curriculum

### Learning Objectives Met

| Kata/Project | Learning Objectives |
|--------------|---------------------|
| **Kata 1** | IDE proficiency, Git workflows |
| **Kata 2** | File I/O, data modeling, collections |
| **Kata 3** | Maven, third-party libraries, charting |
| **Kata 4** | Database integration, SQL, JDBC |
| **Kata 5** | API consumption, HTTP, design patterns |
| **Kata 6** | REST API development, Spring Boot |
| **Kata 7** | Application packaging, deployment |
| **Projects** | Advanced GUI, real-world applications |
| **Simulations** | Physics modeling, numerical methods |

### Evaluation Criteria

✅ **Functionality**: All projects meet requirements  
✅ **Code Quality**: Clean, documented, maintainable  
✅ **Architecture**: Proper design patterns applied  
✅ **Testing**: Manual testing, edge cases considered  
✅ **Documentation**: Comprehensive READMEs included

---

## 🚀 Advanced Topics

### Kata 6: Spring Boot Deep Dive

**Command-Adapter Architecture**:
```java
// Controller delegates to commands
@GetMapping("/**")
public ResponseEntity<String> handleRequest(HttpServletRequest request) {
    Command command = commandFactory.get(path, requestAdapter, responseAdapter);
    command.execute();
    return ResponseEntity.ok(responseAdapter.getBody());
}

// Factory maps paths to commands
commandFactory.register("/api/password", CustomPasswordCommand::new);
```

**Benefits**:
- Easy to add new endpoints (register in factory)
- Testable (mock adapters)
- Separation of concerns (controller ≠ business logic)

### Simulations: Numerical Integration

**Why Runge-Kutta 4th Order?**
- More accurate than Euler method
- Global error: O(dt⁴) vs O(dt²)
- Widely used in physics simulations

**Pendulum Equation**:
```
d²θ/dt² = (g/L) * sin(θ)

// Converted to first-order system:
dθ/dt = ω
dω/dt = (g/L) * sin(θ)
```

---

## 📝 Development Workflow

### Typical Kata/Project Workflow

1. **Understand Requirements**: Read README, identify learning objectives
2. **Design Architecture**: Sketch class diagrams, identify patterns
3. **Implement Core Logic**: Start with model/business layer
4. **Add GUI/API Layer**: Connect to presentation layer
5. **Test Manually**: Verify all features work
6. **Refactor**: Improve code quality, extract methods
7. **Document**: Update README with insights

### Git Best Practices (Kata 1 Focus)

```bash
# Feature branches
git checkout -b feature/kata-3-charts

# Atomic commits
git commit -m "Add JFreeChart bar chart rendering"

# Clean history
git rebase -i HEAD~3  # Squash/reword commits
```

---

## 🤝 Contributing

This repository is primarily for academic purposes. However, improvements are welcome:

1. **Bug Fixes**: Open an issue with steps to reproduce
2. **Enhancements**: Fork, implement, submit PR
3. **Documentation**: Clarify READMEs, add examples

**Contribution Guidelines**:
- Follow existing code style
- Add comments for complex logic
- Update README if adding features
- Ensure backward compatibility

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Sergio Acosta Quintana**  
Computer Engineering Student @ ULPGC  
Software Engineering II — 2024-2025

- 🌐 LinkedIn: [linkedin.com/in/sergioacostaquintana](https://linkedin.com/in/sergioacostaquintana)
- 📧 Email: Available on GitHub profile
- 💼 Portfolio: Check other repositories for cloud, web, and mobile projects

---

## 🙏 Acknowledgments

- **ULPGC Faculty** — Excellent curriculum design (Kata → Projects → Simulations)
- **Open Source Community** — JFreeChart, Spring Boot, Maven ecosystem
- **Stack Overflow** — For those tricky Swing layout issues 😅

---

## 🔗 Related Projects

- [Cloud Computing AWS](../ulpgc-cloud-computing-aws) — Serverless & ETL pipelines
- [Web Development](link-if-exists) — Full-stack JavaScript
- [Mobile Development](link-if-exists) — Android/iOS apps

---

<div align="center">

**⭐ Star this repository if you found it useful!**

Built with ☕ Java | Las Palmas de Gran Canaria, Canary Islands 🇮🇨

---

### 📊 Repository Stats

**7 Katas** | **2 Full Apps** | **2 Simulations** | **~15,000 lines of code**

</div>
