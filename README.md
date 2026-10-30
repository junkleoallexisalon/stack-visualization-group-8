# 2D Stack Visualizer

## Group Name: Group 8

## Group Members
- Jun Kleo Allexis Alon
- Nico Gallardo
- Christian Bantasan
- Jetroh Mejorada
- Jerwen Baja

## Description
The 2D Stack Visualizer is a Java Swing application that demonstrates the
Last-In, First-Out (LIFO) principle of a stack. Each element is drawn as a
block, and the display updates after every operation so it always matches
the real state of the stack.

## Features
- PUSH an integer onto the stack (with input validation).
- POP the top element.
- PEEK at the top element without removing it (highlighted in orange).
- CHECK STACK (IsEmpty) reports whether the stack is empty, and its size.
- CLEAR the stack.
- RANDOM refills the stack with 1–10 random values (1–100).
- STACK OVERFLOW and STACK UNDERFLOW status messages.
- TOP marker and operation history (last 10 operations).

## Requirements
- Java JDK 11 or newer
- Git (optional, for cloning)

## How to Run
```bash
git clone https://github.com/junkleoallexisalon/stack-visualization-group-8.git
cd stack-visualization-group-8
javac *.java
java StackVisualizer
```

## Project Structure
```
stack-visualization-group-8/
├── ArrayStack.java        # Stack component (array-based, max 10)
├── StackVisualizer.java   # Swing GUI component
├── TESTS.md               # Stack trace and boundary test cases
├── screenshots/           # Program screenshots
└── README.md
```

## Stack Implementation
The stack is a custom array-based bounded stack (`ArrayStack`) with a maximum
capacity of 10. An `int[]` stores the elements and an `int top` index
tracks the top element. Methods: `push()`, `pop()`, `peek()`, `isEmpty()`. The GUI (`StackVisualizer`) only talks to the stack through
these methods and never touches the internal array.

 AI Disclosure
- Used Claude for guidance
## Contributors
| Member 
| Jun Kleo Allexis Alon 
| Nico Gallardo 
| Christian Bantasan 
| Jetroh Mejorada 
| Jerwen Baja 
