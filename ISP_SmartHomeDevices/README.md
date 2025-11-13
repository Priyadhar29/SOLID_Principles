# 💡 Interface Segregation Principle (ISP) — Java Example  

## 📘 Overview  
The **Interface Segregation Principle (ISP)** states that:  
> *“Clients should not be forced to depend on interfaces they do not use.”*  

This principle promotes the creation of **small, specific interfaces** rather than one large, generic interface.  
It helps keep your code modular, flexible, and easy to maintain.

---

## 💡 Real-World Scenario: Smart Home Devices  
In a **Smart Home System**, different devices have unique capabilities:  
- A **Smart Light** can turn on/off and adjust brightness.  
- A **Smart AC** can turn on/off and control temperature.  

If both devices were forced to implement a single large interface (with brightness + temperature methods), many of those methods would be **irrelevant**, leading to poor design.

---

## ✅ Correct Implementation  

We design **focused interfaces**:
- `Switchable` → basic control for all devices  
- `AdjustableBrightness` → only for lights  
- `TemperatureControl` → only for air conditioners  

### ✨ Example Flow  

Smart Light is turned ON
Smart Light brightness set to 75
Smart AC is turned ON
Smart AC temperature set to 22°C
Smart AC is turned OFF


Each device implements only the methods it needs — no redundant or empty implementations.

---

## 🚫 Violating Code Example  

A bad design might use one bloated interface:

    ```java
    interface SmartDevice {
    void turnOn();
    void turnOff();
    void setBrightness(int level);
    void setTemperature(int temperature);
    }
    // This forces unrelated classes to implement methods they don’t need:
    @Override
    public void setTemperature(int temperature) {
    throw new UnsupportedOperationException("Not applicable for Smart Light");
    }
    // This breaks ISP, as clients are forced to depend on methods they do not use.

---
## 🔗 Related SOLID Principles

[Single Responsibility Principle (SRP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/SRP_FoodDelivery)

[Open / Closed Principle (OCP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/OCP_NotificationSystem)

[Liskov Substitution Principle (LSP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/LSP_PaymentGateway)

[Dependency Inversion Principle (DIP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/DIP_LoggingSystem)

---
### 🧠 Summary

## ✅ Follows ISP: Classes depend only on what they actually use.
## 🚫 Violates ISP: Classes are forced to implement irrelevant methods.

The ISP helps create clean, modular, and extensible code — essential for scalable real-world applications like IoT and smart home systems.
