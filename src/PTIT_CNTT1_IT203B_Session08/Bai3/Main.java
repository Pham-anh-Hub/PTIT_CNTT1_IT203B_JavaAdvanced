package PTIT_CNTT1_IT203B_Session08.Bai3;

import PTIT_CNTT1_IT203B_Session08.Bai1.AirConditioner;
import PTIT_CNTT1_IT203B_Session08.Bai1.Fan;
import PTIT_CNTT1_IT203B_Session08.Bai1.Light;
import PTIT_CNTT1_IT203B_Session08.Bai3.command.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Gán các nút
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();


        // Cần sửa lại về dạng menu và switch case


        RemoteControl remote = new RemoteControl();

        remote.setCommand(1, new LightOnCommand(light));
        remote.setCommand(2, new LightOffCommand(light));
        remote.setCommand(3, new FanOnCommand(fan));
        remote.setCommand(4, new FanOffCommand(fan));
        remote.setCommand(5, new ACSetTemperatureCommand(ac, 28));

        remote.pressButton(1);
        remote.pressButton(3);
        remote.pressButton(2);

        // undo chức năng trước đó
        remote.undoCommand();
    }
}
