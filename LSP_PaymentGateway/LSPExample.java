package LSP_PaymentGateway;
//✅ LSP Example: Subclasses must be usable wherever the parent is expected.

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

class PaymentProcessor {
 public void makePayment(Payment payment, double amount) {
     payment.pay(amount);
 }
}

public class LSPExample {
 public static void main(String[] args) {
     PaymentProcessor processor = new PaymentProcessor();
     processor.makePayment(new CreditCardPayment(), 1500);
     processor.makePayment(new UpiPayment(), 850);
 }
}

/*OUTPUT:

 Paid ₹1500.0 using Credit Card
 Paid ₹850.0 using UPI
 
*/