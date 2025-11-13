// ✅ ISP Example: Devices implement only the interfaces they actually need.

package ISP_SmartHomeDevices;

interface Switchable {
    void turnOn();
    void turnOff();
}

interface AdjustableBrightness {
    void setBrightness(int level);
}

interface TemperatureControl {
    void setTemperature(int temperature);
}

//Smart Light only needs brightness and switch control
class SmartLight implements Switchable, AdjustableBrightness {
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
}

// Smart AC only needs temperature and switch control
class SmartAC implements Switchable, TemperatureControl {
    @Override
    public void turnOn() {
        System.out.println("Smart AC is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart AC is turned OFF");
    }

    @Override
    public void setTemperature(int temperature) {
        System.out.println("Smart AC temperature set to " + temperature + "°C");
    }
}

class ISPExample {
    public static void main(String[] args) {
        SmartLight light = new SmartLight();
        light.turnOn();
        light.setBrightness(75);

        SmartAC ac = new SmartAC();
        ac.turnOn();
        ac.setTemperature(22);
        ac.turnOff();
    }
}

/*

 OUTPUT:
Smart Light is turned ON
Smart Light brightness set to 75
Smart AC is turned ON
Smart AC temperature set to 22°C
Smart AC is turned OFF

 */