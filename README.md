# Arkanoid Game (Java)

## Overview
This project is a simplified recreation of the classic **Arkanoid** game.  
The game uses a provided **GUI package** (not implemented here) for rendering, while all backend logic, game objects, and event handling were implemented from scratch.

The player controls a **paddle** to bounce a **ball**, breaking blocks to earn points. The game listens for player input, detects collisions between objects, and updates the score accordingly.

---

## Game Features
- **Object-Oriented Design** — The game entities (ball, block, paddle) are modeled as a class.
- **Collision Detection** — Implements collision mechanics between the ball, paddle, and blocks.
- **Listeners and Events** — Uses listener interfaces to handle object removal and scoring.
- **Score Tracking** — Displays and updates the score in real time.
- **Encapsulation of Geometry** — Includes custom classes for `Point`, `Line`, and `Velocity` to handle motion and geometry math.
- **Reusable Game Environment** — All objects interact via a `GameEnvironment` and `SpriteCollection` framework.

---

## 🧩 Project Structure



src/

│
├── CollectionsAndRemovers/ # Object management and collision handling

│   ├── BallRemover.java

│   ├── BlockRemover.java

│   ├── CollisionInfo.java

│   ├── GameEnvironment.java

│   └── SpriteCollection.java

│
├── Game/ # Main game logic and entry point

│   ├── Ass5Game.java

│   └── Game.java

│
├── Geometry/ # Geometry and physics components

│   ├── Ball.java

│   ├── Block.java

│   ├── Line.java

│   ├── Paddle.java

│   ├── Point.java

│   ├── Rectangle.java

│   └── Velocity.java

│
├── Interfaces/ # Core interfaces for interactions

│   ├── Collidable.java

│   ├── HitListener.java

│   ├── HitNotifier.java

│   └── Sprite.java

│
└── Score/ # Score tracking and display

│   ├── Counter.ava
    
│   ├── ScoreIndicator.java
    
│   └── ScoreTrackingListener.java

---

## ⚙️ How to Compile and Run

### 1. Prerequisites
- Java JDK **17+**
- A provided **GUI JAR** (e.g., `biuoop.jar`)  
  Place it under:


lib/biuoop.jar


### 2. Compile
From the project root:
```cmd
javac -d bin -cp lib\biuoop.jar -sourcepath src src\Ass5Game.java


This command:

Compiles all .java files starting from the entry point Ass5Game.java.

Places .class files in the bin directory.

Includes the GUI library during compilation.

3. Run
java -cp bin;lib\biuoop.jar Ass5Game


⚠️ Use : instead of ; as the classpath separator on macOS/Linux.

🧠 Key Classes
Package	Class	Description
Game	Manages initialization, game loop, and updates.
Paddle	Handles player input and paddle movement.
Ball, Block, Rectangle, Line	Define shapes, movement, and collision detection.
HitListener, BlockRemover, ScoreTrackingListener	Handle events such as block removal and scoring.
GameEnvironment, Collidable	Central hub for collision detection between all game objects.
🧩 Game Logic Summary

The Game class creates all game objects: paddle, ball, and blocks.

Each Frame:

The ball moves according to its Velocity.

Collision checks are performed via GameEnvironment.

Listeners are notified on hits to update score or remove blocks.

The player uses the keyboard to move the paddle left/right.

The game ends when the ball falls below the screen or all blocks are cleared.

Author:
Eran Shalev Hamdani.

Developed as part of an object-oriented programming assignment (Assignment 5).
Focus: Backend logic, event handling, and collision mechanics.
GUI library provided externally.
