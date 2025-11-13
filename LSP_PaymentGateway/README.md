# 🔁 Liskov Substitution Principle (LSP) — Java Example  

## 📘 Overview  
The **Liskov Substitution Principle (LSP)** states that:  
> *“Subtypes must be substitutable for their base types without altering the correctness of the program.”*  

In simple terms — if a program works with a parent class, it should also work perfectly with any of its subclasses **without needing changes or unexpected behavior**.

---

## 💡 Real-World Scenario: Payment Gateway  
Imagine an online payment system that supports different payment methods like **Credit Card** and **UPI**.  

Each payment type should behave consistently — the system should not need to know *which* payment type is being used, only that it can **process payments** reliably.

---

## ✅ Correct Implementation  

In the correct design:
- The base class `Payment` defines a general method `pay(double amount)`.
- Each subclass (`CreditCardPayment`, `UpiPayment`) implements it consistently.  
- The `PaymentProcessor` can use any subclass **interchangeably**.

---

### ✨ Example Flow  

Paid ₹1500.0 using Credit Card
Paid ₹850.0 using UPI


Here, both subclasses behave as expected — no special conditions or broken logic.

---

## 🚫 Violating Code Example  

A bad implementation might look like this:
    
    ```java
    class GiftCardPayment extends Payment {
        void pay(double amount) {
            if (amount > 500) {
                throw new UnsupportedOperationException("Gift Card cannot process payments above ₹500");
            }
            System.out.println("Paid ₹" + amount + " using Gift Card");
        }
     }

When this class replaces Payment in your program, it breaks the flow (throws exceptions, adds restrictions) — violating LSP.

---

## 📊 UML Diagram Suggestion

Classes:

Payment (Abstract Class)

CreditCardPayment, UpiPayment, GiftCardPayment (Concrete Classes)

PaymentProcessor (Uses Payment polymorphically)

Relationships:

PaymentProcessor → depends on → Payment

Each concrete class → extends → Payment

---

## 🔗 Related SOLID Principles

[Single Responsibility Principle (SRP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/SRP_FoodDelivery)

[Open / Closed Principle (OCP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/OCP_NotificationSystem)

[Interface Segregation Principle (ISP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/ISP_SmartHomeDevices)

[Dependency Inversion Principle (DIP)](https://github.com/Priyadhar29/SOLID_Principles/tree/main/DIP_LoggingSystem)

---

## 🧠 Summary

✅ Follows LSP: Subclasses can replace base class seamlessly.
🚫 Violates LSP: Subclasses restrict or change expected behavior.

The LSP ensures consistency, reliability, and true polymorphism in OOP design.

---

## 👩‍💻 Author: Priya Dharshini
## 📅 Practicing SOLID Principles in Java — Step by Step
