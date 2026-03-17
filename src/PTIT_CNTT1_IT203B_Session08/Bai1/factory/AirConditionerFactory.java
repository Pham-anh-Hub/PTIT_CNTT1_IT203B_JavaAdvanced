package PTIT_CNTT1_IT203B_Session08.Bai1.factory;

import PTIT_CNTT1_IT203B_Session08.Bai1.AirConditioner;
import PTIT_CNTT1_IT203B_Session08.Bai1.Device;

public class AirConditionerFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        System.out.println("Đã tạo điều hòa mới");
        return new AirConditioner();
    }
}
