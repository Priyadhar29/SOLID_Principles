package LSP_PaymentGateway;

//❌ Violates LSP: Not all subclasses can be used interchangeably
abstract class Payment {
 abstract void pay(double amount);
}

class CreditCardPayment extends Payment {
 void pay(double amount) {
     System.out.println("Paid ₹" + amount + " using Credit Card");
 }
}

class UpiPayment extends Payment {
 void pay(double amount) {
     System.out.println("Paid ₹" + amount + " using UPI");
 }
}

//❌ This subclass changes the behavior — violates expectations
class GiftCardPayment extends Payment {
 void pay(double amount) {
     if (amount > 500) {
         throw new UnsupportedOperationException("Gift Card cannot process payments above ₹500");
     }
     System.out.println("Paid ₹" + amount + " using Gift Card");
 }
}

class PaymentProcessor {
 public void makePayment(Payment payment, double amount) {
     // Expecting all Payment subclasses to behave consistently
     payment.pay(amount);
 }
}

public class LSPViolation {
 public static void main(String[] args) {
     PaymentProcessor processor = new PaymentProcessor();

     processor.makePayment(new CreditCardPayment(), 1500);
     processor.makePayment(new UpiPayment(), 850);

     // ❌ Violates LSP – this will break program flow
     processor.makePayment(new GiftCardPayment(), 1000);
 }
}

/*
❌ Why This Violates LSP

GiftCardPayment cannot handle all amounts, unlike its parent class contract (Payment), so:

The subclass cannot fully substitute its parent.

Code using Payment must now check the type or handle exceptions — breaking polymorphism.

LSP ensures subclasses don’t weaken or break the behavior promised by their base class.

OUTPUT:

Paid ₹1500.0 using Credit Card
Paid ₹850.0 using UPI
Exception in thread "main" java.lang.UnsupportedOperationException: Gift Card cannot process payments above ₹500
	at LSP_PaymentGateway.GiftCardPayment.pay(LSPViolation.java:24)
	at LSP_PaymentGateway.PaymentProcessor.makePayment(LSPExample.java:22)
	at LSP_PaymentGateway.LSPViolation.main(LSPViolation.java:45)

*/