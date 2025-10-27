package SRP_FoodDelivery;

//❌ Violating SRP: One class doing multiple jobs — order, payment, and notification.

public class SRPViolation {
	private String orderId;
	private double amount;

	public SRPViolation(String orderId, double amount) {
		this.orderId = orderId;
		this.amount = amount;
	}

  // ❌ Also handles payment logic
	
	public void processPayment() {
		System.out.println("Processing payment for order: " + orderId + " | Amount: ₹" + amount);
		
		// Imagine a payment gateway API here
	
		System.out.println("Payment successful for " + orderId);
	}

	// ❌ Also handles notification logic
	
	public void sendOrderNotification() {
		System.out.println("Notification sent to customer for order: " + orderId);
	}

	// ❌ Main method doing everything
	
	public static void main(String[] args) {
		SRPViolation order = new SRPViolation("ORD1001", 599.0);
		order.processPayment();
		order.sendOrderNotification();
	}
}