# 🧩 Single Responsibility Principle (SRP) – Java Example

## 💡 What is SRP?
The **Single Responsibility Principle** states that *a class should have only one reason to change*, meaning it should have just one job or responsibility.

In simple terms — **one class = one purpose**.

---

## 🚫 SRP Violating Example
In the violating version, a single class handles:
- Order creation  
- Payment processing  
- Notification sending  

This creates **tight coupling**, makes the code **hard to maintain**, and **reduces flexibility**.

---

## ✅ Correct SRP Implementation
In the corrected version, each class has a **clear, single responsibility**:
- `Order` → Manages order details  
- `PaymentProcessor` → Handles payments  
- `NotificationService` → Sends notifications  
- `SRPCorrectExample` → Coordinates the workflow  

---

## ⚙️ Benefits of Applying SRP
- Easier to **maintain and test**  
- **Reusable** classes across projects  
- **Scalable** for adding new features  
- **Improves readability** and teamwork  

---

## 🏢 Real-World Analogy
Think of a restaurant:
- The **chef** cooks the food (like `Order`)  
- The **cashier** manages payments (`PaymentProcessor`)  
- The **waiter** handles communication (`NotificationService`)  

Each person has **one clear role**, which keeps things organized and efficient.

---
## 🔗 Related SOLID Principles

[Open / Closed Principle (OCP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/OCP_NotificationSystem)

[Liskov Substitution Principle (LSP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/LSP_PaymentGateway)

[Interface Segregation Principle (ISP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/ISP_SmartHomeDevices)

[Dependency Inversion Principle (DIP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/DIP_LoggingSystem)

---
