# 💳 Smart Payment System — Applying All SOLID Principles in Java

## 📘 Overview  
The **Smart Payment System** is a **mini Java console application** that demonstrates **all five SOLID principles** using real-world concepts like payment processing, notifications, and transaction logging.  

Users can:
- Enter a transaction ID and amount  
- Choose a payment method (Credit Card, UPI, Wallet)  
- Choose a notification type (Email or SMS)  
- Process multiple transactions interactively  

This project integrates **Object-Oriented Programming (OOP)** and **SOLID Design Principles** to create a scalable, maintainable, and loosely coupled payment system.

---

## 🧱 SOLID Principles Implemented  

| Principle | Applied In | Description |
|------------|-------------|-------------|
| **S – Single Responsibility** | `TransactionLogger` | Handles only transaction logging — not payment or notification. |
| **O – Open/Closed** | `Payment` interface & new payment classes | Add new payment types (e.g., CryptoPayment) without modifying existing code. |
| **L – Liskov Substitution** | All classes implementing `Payment` | Any payment class can replace another without breaking the system. |
| **I – Interface Segregation** | `NotificationService`, `Payment` | Devices/classes implement only the interfaces they need (Email or SMS notification). |
| **D – Dependency Inversion** | `PaymentProcessor` | Depends on abstractions (`Payment`, `NotificationService`), not concrete classes. |


---

## ⚙️ Features  
✅ Accepts **user input** for transaction details  
✅ Supports **multiple payment methods**  
✅ Sends **notifications** via Email or SMS  
✅ Logs all transactions  
✅ Uses **dependency injection** to stay modular  
✅ Fully **console-interactive**  
✅ Demonstrates all **SOLID + OOP concepts**

---

## 💡 Example Run  

=== 💰 Smart Payment Gateway ===

Enter Transaction ID: TXN1023
Enter Amount: ₹1500

Choose Payment Method:

Credit Card

UPI

Wallet
Enter choice: 2

Choose Notification Type:

Email

SMS
Enter choice: 1

📱 Processing UPI payment of ₹1500.0
📧 Email Notification: Payment of ₹1500.0 successful for Transaction ID: TXN1023
🧾 Transaction Logged: TXN1023 | Amount: ₹1500.0

✅ Payment processed successfully following SOLID principles!

Do you want to make another payment? (yes/no): no

👋 Thank you for using Smart Payment Gateway. Have a great day!


---

## 🧠 How SOLID is Applied  

### 🧩 **Single Responsibility Principle (SRP)**  
Each class does **only one job**:
- `PaymentProcessor` → coordinates the payment workflow  
- `TransactionLogger` → logs transactions  
- `NotificationService` → handles notifications  

### 🔒 **Open/Closed Principle (OCP)**  
The `Payment` interface allows you to add new payment types (like Crypto or NetBanking) **without changing existing code**.  

### 🔁 **Liskov Substitution Principle (LSP)**  
All `Payment` implementations (`CreditCardPayment`, `UPIPayment`, etc.) can be used interchangeably without breaking functionality.  

### 🧱 **Interface Segregation Principle (ISP)**  
Separate interfaces (`Payment`, `NotificationService`) ensure classes implement **only what they need** — improving modularity.  

### 🧩 **Dependency Inversion Principle (DIP)**  
The `PaymentProcessor` depends on **abstractions** (interfaces) — not concrete classes.  
Dependencies like payment method and notification type are **injected dynamically**.

---

## 🚀 Future Enhancements  
- 🔐 Add **authentication layer** for users  
- 💰 Support **Crypto / NetBanking / Cardless EMI**  
- 📊 Store transactions in a **database or file**  
- 🌐 Add a **GUI version** using JavaFX or Spring Boot  

---

## 🧾 Summary  
| Design Goal | Achieved Through |
|--------------|------------------|
| Maintainability | Separation of responsibilities |
| Extensibility | Open/Closed structure |
| Reusability | Interface-based design |
| Testability | Dependency Injection |
| Scalability | OOP + SOLID foundation |

---

## 🔗 Related Individual SOLID Modules  
- [SRP - Order Management](../SRP_OrderManagement/README.md)  
- [OCP - Notification System](../OCP_NotificationSystem/README.md)  
- [LSP - Payment Gateway](../LSP_PaymentGateway/README.md)  
- [ISP - Smart Home Devices](../ISP_SmartHomeDevices/README.md)  
- [DIP - Logging System](../DIP_LoggingSystem/README.md)  

---

👩‍💻 **Author:** Priya Dharshini  
📅 *Practicing SOLID Principles through Real-World Java Projects*  
🌐 *GitHub Portfolio Series — SOLID in Action*

---
