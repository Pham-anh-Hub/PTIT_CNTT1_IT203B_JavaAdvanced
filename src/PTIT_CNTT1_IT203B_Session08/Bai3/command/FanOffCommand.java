package PTIT_CNTT1_IT203B_Session08.Bai3.command;

import PTIT_CNTT1_IT203B_Session08.Bai1.Fan;
import PTIT_CNTT1_IT203B_Session08.Bai3.Command;

public class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }

    @Override
    public void undo() {
        fan.turnOn();
    }
}
