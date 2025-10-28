# 🎯 Design Patterns Project (Strategy | Observer | Decorator)

## 📘 Overview
This project demonstrates the implementation of **three fundamental design patterns** in Object-Oriented Programming — **Strategy**, **Observer**, and **Decorator** — using Java.  
Each pattern is implemented through a real-world inspired example to show how design patterns enhance flexibility, scalability, and maintainability in software development.

---

## 🧩 Implemented Patterns

### 1. 🧠 Strategy Pattern
The **Strategy Pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable.  
It allows the algorithm to vary independently from the clients that use it.

**Example:**  
A payment system that supports multiple payment methods (e.g., Credit Card, PayPal, or Bitcoin).  
The payment behavior can be changed at runtime without modifying the main logic.

**Key Classes:**
- `PaymentStrategy` (interface)
- `CreditCardPayment`, `PayPalPayment`, `BitcoinPayment` (concrete strategies)
- `ShoppingCart` (context)

---

### 2. 👁️ Observer Pattern
The **Observer Pattern** establishes a one-to-many dependency between objects.  
When one object (the subject) changes its state, all its dependents (observers) are automatically notified.

**Example:**  
A news agency system where subscribers receive updates whenever a new article is published.

**Key Classes:**
- `Subject` and `Observer` interfaces  
- `NewsAgency` (concrete subject)  
- `Subscriber` (concrete observer)

---

### 3. 🎨 Decorator Pattern
The **Decorator Pattern** dynamically adds new behavior to an object without altering its structure.  
It’s an alternative to subclassing for extending functionality.

**Example:**  
A coffee shop system where you can decorate a basic coffee with extras like milk, sugar, or caramel dynamically.

**Key Classes:**
- `Coffee` (interface)
- `BasicCoffee` (concrete component)
- `MilkDecorator`, `SugarDecorator`, `CaramelDecorator` (decorators)

---

## 🛠️ Technologies Used
- **Java 17**
- **OOP Principles (Encapsulation, Inheritance, Polymorphism)**
- **IntelliJ IDEA / VS Code**

---

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/design-patterns.git
