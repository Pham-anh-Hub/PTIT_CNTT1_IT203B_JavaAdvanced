package PTIT_CNTT1_IT203B_Session08.Bai1;

public class Light implements Device{

    private boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public void setOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        System.out.println("Đèn đã tắt");
    }

    @Override
    public void turnOn() {
        System.out.println("Đèn đã bật");
    }
}
