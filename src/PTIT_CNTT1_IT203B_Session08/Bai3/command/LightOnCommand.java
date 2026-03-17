package PTIT_CNTT1_IT203B_Session08.Bai3.command;

import PTIT_CNTT1_IT203B_Session08.Bai1.Light;
import PTIT_CNTT1_IT203B_Session08.Bai3.Command;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}
