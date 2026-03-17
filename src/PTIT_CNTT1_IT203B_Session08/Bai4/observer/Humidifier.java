package PTIT_CNTT1_IT203B_Session08.Bai4.observer;

import PTIT_CNTT1_IT203B_Session08.Bai4.Observer;

public class Humidifier implements Observer {
    @Override
    public void update(int tempurature) {
        System.out.println("Máy tạo ẩm: Điều chỉnh nhiệt độ cho nhiệt độ " + tempurature);
    }
}
