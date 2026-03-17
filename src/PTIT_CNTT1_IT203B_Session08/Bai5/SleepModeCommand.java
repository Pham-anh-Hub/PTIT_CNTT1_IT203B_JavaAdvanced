package PTIT_CNTT1_IT203B_Session08.Bai5;

import PTIT_CNTT1_IT203B_Session08.Bai1.AirConditioner;
import PTIT_CNTT1_IT203B_Session08.Bai1.Fan;
import PTIT_CNTT1_IT203B_Session08.Bai1.Light;

public class SleepModeCommand implements Command{
    private Light light = new Light();
    private Fan fan = new Fan();
    private AirConditioner airConditioner = new AirConditioner();

    private boolean sleepMode;



    public SleepModeCommand() {
        this.sleepMode = false;
    }

    public void setSleepMode(boolean sleepMode) {
        this.sleepMode = sleepMode;
    }

    public boolean getSleepMode() {
        return sleepMode;
    }

    @Override
    public void execute() {
        System.out.println("SleepMode: Tắt đèn\n" +
                "SleepMode: Điều hòa set 28°C\n" +
                "SleepMode: Quạt tốc độ thấp");
        // thực hiện lần lượt các lệnh:
        // tắt đèn,
        light.turnOff();
        // set nhiệt độ 28, mặc định nhiệt độ ổn định,
        airConditioner.setTempurature(28);
        // set quạt thấp.
        fan.lowFan();
        this.setSleepMode(true);

    }

    @Override
    public void undo() {

    }
}
