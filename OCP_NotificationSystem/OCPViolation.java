package OCP_NotificationSystem;

class notifyServ {
    public void notifyUser(String type, String message) {
        if (type.equalsIgnoreCase("email")) {
            System.out.println("Sending Email: " + message);
        } else if (type.equalsIgnoreCase("sms")) {
            System.out.println("Sending SMS: " + message);
        } else if (type.equalsIgnoreCase("whatsapp")) {
            System.out.println("Sending WhatsApp Message: " + message);
        } else {
            System.out.println("Invalid notification type!");
        }
    }
}

public class OCPViolation {
    public static void main(String[] args) {
        notifyServ service = new notifyServ();
        service.notifyUser("email", "Your order has been shipped!");
        service.notifyUser("sms", "Your OTP is 123456");
        service.notifyUser("whatsapp", "Meeting at 10 AM tomorrow");
    }
}

/*❌ Why This Violates OCP

Each time a new notification type (like Push or Slack) is added, you must modify the NotifyServ class.

This breaks the Open/Closed Principle:

❌ Not closed for modification

❌ Not easily extendable

Leads to long if-else chains and code fragility.

 OUTPUT:
 
    Sending Email: Your order has been shipped!
	Sending SMS: Your OTP is 123456
	Sending WhatsApp Message: Meeting at 10 AM tomorrow

 */