package ISP_SmartHomeDevices;

//❌ One big interface — forces all devices to implement irrelevant methods
interface SmartDevice {
 void turnOn();
 void turnOff();
 void setBrightness(int level);
 void setTemperature(int temperature);
}

//❌ Smart Light does not need temperature control
class SmartLight implements SmartDevice {

 @Override
 public void turnOn() {
     System.out.println("Smart Light is turned ON");
 }

 @Override
 public void turnOff() {
     System.out.println("Smart Light is turned OFF");
 }

 @Override
 public void setBrightness(int level) {
     System.out.println("Smart Light brightness set to " + level);
 }

 // ❌ Irrelevant method for light
 @Override
 public void setTemperature(int temperature) {
     throw new UnsupportedOperationException("Temperature control not applicable for Smart Light");
 }
}

//❌ Smart AC does not need brightness control
class SmartAC implements SmartDevice {

 @Override
 public void turnOn() {
     System.out.println("Smart AC is turned ON");
 }

 @Override
 public void turnOff() {
     System.out.println("Smart AC is turned OFF");
 }

 // ❌ Irrelevant method for AC
 @Override
 public void setBrightness(int level) {
     throw new UnsupportedOperationException("Brightness control not applicable for Smart AC");
 }

 @Override
 public void setTemperature(int temperature) {
     System.out.println("Smart AC temperature set to " + temperature + "°C");
 }
}

public class ISPViolation {
 public static void main(String[] args) {
     SmartLight light = new SmartLight();
     light.turnOn();
     light.setBrightness(80);
     try {
         // ❌ Throws exception — violates ISP
         light.setTemperature(25);
     } catch (UnsupportedOperationException e) {
         System.out.println("Error: " + e.getMessage());
     }

     SmartAC ac = new SmartAC();
     ac.turnOn();
     ac.setTemperature(22);
     try {
         // ❌ Throws exception — violates ISP
         ac.setBrightness(70);
     } catch (UnsupportedOperationException e) {
         System.out.println("Error: " + e.getMessage());
     }
     ac.turnOff();
 }
}
 
/*  It will throw an exception 

    Smart Light is turned ON
	Smart Light brightness set to 80
	Exception in thread "main" java.lang.NoSuchMethodError: 'void ISP_SmartHomeDevices.SmartLight.setTemperature(int)'
			at ISP_SmartHomeDevices.ISPViolation.main(ISPViolation.java:68)

 */
