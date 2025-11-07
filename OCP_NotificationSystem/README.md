# 🔒 Open/Closed Principle (OCP) — Java Example  

## 📘 Overview  
The **Open/Closed Principle (OCP)** states that:  
> *“Software entities (classes, modules, functions) should be open for extension but closed for modification.”*  

This means you should be able to **add new functionality** without **changing existing code** — ensuring flexibility and preventing regressions.  

---

## 💡 Real-World Scenario: Notification System  

Imagine a company’s system that sends notifications via **Email**, **SMS**, or **WhatsApp**.  
Instead of editing the same class every time we add a new notification type, we can simply **extend the system** using interfaces and new implementations.

---

## ✅ Correct Implementation  

- Follows **OCP** using an interface `Notifier`.  
- Each notification type (Email, SMS, WhatsApp) implements its own `send()` logic.  
- The `NotificationService` depends only on the **Notifier abstraction**, not concrete classes.  

---

### ✨ Example Flow  

Your order has been shipped! -> sent via Email
Your OTP is 123456 -> sent via SMS
Meeting at 10 AM tomorrow -> sent via WhatsApp

You can add a new notifier (e.g., PushNotification) **without touching existing code** — just implement the `Notifier` interface.

---

## 🚫 Violating Code  

In the violating version, every new notification type requires modifying the same class:  

     ```java
    class NotificationService {
    void notifyUser(String type, String message) {
        if(type.equals("EMAIL")) { ... }
        else if(type.equals("SMS")) { ... }
        else if(type.equals("WHATSAPP")) { ... }
    }
    }

This approach breaks OCP because adding a new type (like PushNotification) means editing this class again, risking errors and making maintenance harder.

---

## 📊 UML Diagram Suggestion

Classes:

Notifier (Interface)

EmailNotifier, SMSNotifier, WhatsappNotifier (Concrete Implementations)

NotificationService (Uses the Notifier interface)

Relationships:

NotificationService → depends on → Notifier

Each concrete class → implements → Notifier

---

## 🔗 Related SOLID Principles

[Single Responsibility Principle (SRP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/SRP_FoodDelivery)

[Liskov Substitution Principle (LSP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/LSP_PaymentGateway)

[Interface Segregation Principle (ISP)]()

[Dependency Inversion Principle (DIP)]()

---

## 🧠 Summary

✅ Open for extension → Easily add new features.
🚫 Closed for modification → Don’t touch stable code.
OCP helps build flexible, maintainable, and scalable software systems.

---

### 👩‍💻 Author: Priya Dharshini
### 📅 Practicing SOLID Principles in Java — Step by Step

---
