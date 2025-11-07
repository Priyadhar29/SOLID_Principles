package OCP_NotificationSystem;
//✅ OCP Example: Add new notification types without modifying core logic.

//interface 
interface Notifier{
    void send(String message);
}

//class that implements interface
class EmailNotifier implements Notifier{
    public void send(String message){
        System.out.println("Sending Email: "+ message);
    }
}

class SMSNotifier implements Notifier{
    public void send(String message){
        System.out.println("Sending SMS: "+ message);
    }
}   

class WhatsappNotifier implements Notifier{
    public void send(String message){
        System.out.println("Sending WhatsApp Message: "+ message);
    }
}


class NotificationService{
    private Notifier notifier;
    public NotificationService(Notifier notifier){
        this.notifier = notifier;
    }
    public void notifyUser(String message){
        notifier.send(message);
    }
}

public class OCPExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        NotificationService emailService = new NotificationService(emailNotifier);
        emailService.notifyUser("Your order has been shipped!");

        Notifier smsNotifier = new SMSNotifier();
        NotificationService smsService = new NotificationService(smsNotifier);
        smsService.notifyUser("Your OTP is 123456");

        Notifier whatsappNotifier = new WhatsappNotifier();
        NotificationService whatsappService = new NotificationService(whatsappNotifier);
        whatsappService.notifyUser("Meeting at 10 AM tomorrow");
    }
}



/* OUTPUT:
 
    Sending Email: Your order has been shipped!
	Sending SMS: Your OTP is 123456
	Sending WhatsApp Message: Meeting at 10 AM tomorrow

 */