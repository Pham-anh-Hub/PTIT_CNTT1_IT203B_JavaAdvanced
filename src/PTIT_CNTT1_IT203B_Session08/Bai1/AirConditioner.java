package PTIT_CNTT1_IT203B_Session08.Bai1;

public class AirConditioner implements Device{
    private double tempurature = 26; // set nhiệt độ ban đầu

    public double getTempurature() {
        return tempurature;
    }

    @Override
    public void turnOn() {
        System.out.println("Điều hòa đã được bật");
    }


    @Override
    public void turnOff() {
        System.out.println("Điều hòa đã tắt");
    }

    public void setTempurature(double currentTemp){
        System.out.println("Điều hòa được điều chỉnh đến: " + currentTemp + " độ C");
    }
}
