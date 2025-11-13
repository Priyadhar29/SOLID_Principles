# ⚙️ Dependency Inversion Principle (DIP) — Java Example  

## 📘 Overview  
The **Dependency Inversion Principle (DIP)** states that:  
> *“High-level modules should not depend on low-level modules. Both should depend on abstractions.”*  

This means we should design our code such that **classes depend on interfaces (abstractions)** rather than concrete implementations.  
This makes systems more **flexible, testable, and maintainable**.

---

## 💡 Real-World Scenario: Logging System  

In an application, we may want to log information to:
- The **console**
- A **file**
- A **database**
- Or even a **remote monitoring service**

If the main application class directly depends on a specific logger (like `ConsoleLogger`), changing the logging method later would require modifying the main class — **violating DIP**.  

---

## ✅ Correct Implementation  

We create an **abstraction (`Logger`)** that defines the behavior, and **concrete classes** implement it differently:
- `ConsoleLogger` → logs to console  
- `FileLogger` → logs to file  

The `Application` class depends only on the **Logger interface**, not on the specific type of logger.

---

### ✨ Example Flow 

[Console Log] Task started...
Performing some work...
[Console Log] Task completed successfully!

[File Log] Task started... (written to file)
Performing some work...
[File Log] Task completed successfully! (written to file)


---

## 🚫 Violating Code Example  

A bad design would directly depend on a low-level module:

    ```java
    class Application {
    private ConsoleLogger logger = new ConsoleLogger(); // ❌ tightly coupled

    public void performTask() {
        logger.log("Task started...");
        System.out.println("Performing work...");
        logger.log("Task completed!");
    }
    }

    // Here, if we ever want to log to a file or a database, we must modify the Application class itself — breaking DIP and the Open/Closed Principle (OCP) as well.

---

## 🔗 Related SOLID Principles

[Single Responsibility Principle (SRP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/SRP_FoodDelivery)

[Open / Closed Principle (OCP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/OCP_NotificationSystem)

[Liskov Substitution Principle (LSP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/LSP_PaymentGateway)

[Interface Segregation Principle (ISP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/ISP_SmartHomeDevices)

---

### 🧠 Summary

## ✅ Follows DIP: High-level module depends on abstraction (Logger).
## 🚫 Violates DIP: High-level module directly depends on low-level (ConsoleLogger).

By applying DIP, your code becomes modular, extensible, and adaptable — crucial for scalable systems like enterprise apps, IoT, or microservices.

---
