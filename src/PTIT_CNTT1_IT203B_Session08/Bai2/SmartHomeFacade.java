package PTIT_CNTT1_IT203B_Session08.Bai2;

import PTIT_CNTT1_IT203B_Session08.Bai1.AirConditioner;
import PTIT_CNTT1_IT203B_Session08.Bai1.Fan;
import PTIT_CNTT1_IT203B_Session08.Bai1.Light;

public class SmartHomeFacade {
    private Light light = new Light();
    private Fan fan = new Fan();
    private AirConditioner  airConditioner = new AirConditioner();
    private TemperatureSensor sensor; // Đối tượng cảm biến nhiệt độ


    public SmartHomeFacade(TemperatureSensor sensor) {
        this.sensor = sensor;
    }

    void leaveHome(){
        light.turnOff();
        fan.turnOff();
        airConditioner.turnOff();
        System.out.println("Kích hoạt chế độ rời nhà!!\n");
    };

    void sleepMode(){
        light.turnOff();
        airConditioner.setTempurature(27);
        fan.turnOff(); // có thể mở rộng thêm với chức năng cho nhỏ mức quạt
        System.out.println("Kích hoạt chế độ ngủ!!\n");
    }

    void getCurrentTemperature(){
        double currentTemp = this.sensor.getTemperatureCelsius();
        System.out.println("Nhiệt độ hiện tại: " + currentTemp + " độ C");
    }
}
