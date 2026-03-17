package PTIT_CNTT1_IT203B_Session08.Bai3.command;

import PTIT_CNTT1_IT203B_Session08.Bai1.Light;
import PTIT_CNTT1_IT203B_Session08.Bai3.Command;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}
