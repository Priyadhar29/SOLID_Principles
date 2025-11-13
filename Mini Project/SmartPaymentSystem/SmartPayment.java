package SmartPaymentSystem;

import java.util.*;

// -------------------
// Abstraction Layer
// -------------------
interface Payment {
    void pay(double amount);
}

// -------------------
// OCP + LSP
// -------------------
class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("💳 Processing Credit Card payment of ₹" + amount);
    }
}

class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("📱 Processing UPI payment of ₹" + amount);
    }
}

class WalletPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("👛 Processing Wallet payment of ₹" + amount);
    }
}

// -------------------
// ISP
// -------------------
interface NotificationService {
    void sendNotification(String message);
}

class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("📧 Email Notification: " + message);
    }
}

class SMSNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("📩 SMS Notification: " + message);
    }
}

// -------------------
// SRP
// -------------------
class TransactionLogger {
    public void logTransaction(String transactionId, double amount) {
        System.out.println("🧾 Transaction Logged: " + transactionId + " | Amount: ₹" + amount);
    }
}

// -------------------
// DIP
// -------------------
class PaymentProcessor {
    private final Payment paymentMethod;
    private final NotificationService notifier;
    private final TransactionLogger logger;

    public PaymentProcessor(Payment paymentMethod, NotificationService notifier, TransactionLogger logger) {
        this.paymentMethod = paymentMethod;
        this.notifier = notifier;
        this.logger = logger;
    }

    public void process(String transactionId, double amount) {
        paymentMethod.pay(amount);
        notifier.sendNotification("Payment of ₹" + amount + " successful for Transaction ID: " + transactionId);
        logger.logTransaction(transactionId, amount);
    }
}

// -------------------
// Main Class
// -------------------
public class SmartPayment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TransactionLogger logger = new TransactionLogger();

        System.out.println("=== 💰 Smart Payment Gateway ===");

        boolean continuePayment = true;
        while (continuePayment) {
            System.out.print("\nEnter Transaction ID: ");
            String txnId = sc.nextLine();

            System.out.print("Enter Amount: ₹");
            double amount = sc.nextDouble();
            sc.nextLine(); // consume newline

            System.out.println("\nChoose Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Wallet");
            System.out.print("Enter choice: ");
            int payChoice = sc.nextInt();
            sc.nextLine();

            Payment payment;
            switch (payChoice) {
                case 1 -> payment = new CreditCardPayment();
                case 2 -> payment = new UPIPayment();
                case 3 -> payment = new WalletPayment();
                default -> {
                    System.out.println("Invalid choice! Defaulting to UPI.");
                    payment = new UPIPayment();
                }
            }

            System.out.println("\nChoose Notification Type:");
            System.out.println("1. Email");
            System.out.println("2. SMS");
            System.out.print("Enter choice: ");
            int notifChoice = sc.nextInt();
            sc.nextLine();

            NotificationService notifier = (notifChoice == 1) ? new EmailNotification() : new SMSNotification();

            // Dependency Injection
            PaymentProcessor processor = new PaymentProcessor(payment, notifier, logger);

            System.out.println("\n-----------------------------------");
            processor.process(txnId, amount);
            System.out.println("-----------------------------------");
            System.out.println("✅ Payment processed successfully following SOLID principles!");

            System.out.print("\nDo you want to make another payment? (yes/no): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (!choice.equals("yes")) {
                continuePayment = false;
                System.out.println("\n👋 Thank you for using Smart Payment Gateway. Have a great day!");
            }
        }

    }
}
