package PTIT_CNTT1_IT203B_Session08.Bai2;

public class ThermometerAdapter implements TemperatureSensor{

    private OldThermometer oldThermometer;

    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    @Override
    public void setTempurature(double inTempurature) {
        
    }

    @Override
    public double getTemperatureCelsius() {
        return (oldThermometer.getTemperatureFahrenheit() - 32) * 5/9 ;
    }
}
