package PTIT_CNTT1_IT203B_Session08.Bai1.factory;

import PTIT_CNTT1_IT203B_Session08.Bai1.Device;
import PTIT_CNTT1_IT203B_Session08.Bai1.Light;

public class LightFactory extends DeviceFactory{

    @Override
    public Device createDevice() {
        System.out.println("Đã tạo đèn mới");
        return new Light();
    }
}
