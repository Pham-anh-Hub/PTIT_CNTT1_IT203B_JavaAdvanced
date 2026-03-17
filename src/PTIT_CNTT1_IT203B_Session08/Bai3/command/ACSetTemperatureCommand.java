package PTIT_CNTT1_IT203B_Session08.Bai3.command;

import PTIT_CNTT1_IT203B_Session08.Bai1.AirConditioner;
import PTIT_CNTT1_IT203B_Session08.Bai3.Command;

public class ACSetTemperatureCommand implements Command {

    private AirConditioner airConditioner;
    private double oldTemp;
    private double newTemp;


    public ACSetTemperatureCommand(AirConditioner airConditioner, double temp) {
        this.airConditioner = airConditioner;
        this.newTemp = temp;
    }

    @Override
    public void execute() {
        oldTemp = airConditioner.getTempurature();
        airConditioner.setTempurature(newTemp);
    }

    @Override
    public void undo() {
        airConditioner.setTempurature(oldTemp);
    }
}
