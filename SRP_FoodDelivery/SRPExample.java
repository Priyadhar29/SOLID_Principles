//Each class one clear responsibility

package SRP_FoodDelivery;

class Order{
	private String orderId;
	private double amount;
	public Order(String orderId, double amount) {
		this.orderId=orderId;
		this.amount=amount;
	}
	public String getOrderId() {
		return orderId;
	}
	public double getAmount() {
		return amount;
	}
}

//Handles Payment only

class PaymentProcessor{
	public void processPayment(Order order) {
		System.out.println("Processing payment for Order ID: "+ order.getOrderId());	
	}
}

//Handles Notification only

class NotificationService{
	public void sendOrderNotification(Order order) {
		System.out.println("Notification sent for "+ order.getOrderId()+ " paid: "+order.getAmount());	
	}
}

public class SRPExample {
    public static void main(String[] args) {
    	Order o = new Order("ORD1", 589);
    	PaymentProcessor pay = new PaymentProcessor();
    	NotificationService notify = new NotificationService();
    	
    	pay.processPayment(o);
    	notify.sendOrderNotification(o);
    }
}