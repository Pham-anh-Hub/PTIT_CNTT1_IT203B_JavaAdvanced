package PTIT_CNTT1_IT203B_Session07.BTTH.notification.impl;

import PTIT_CNTT1_IT203B_Session07.BTTH.notification.NotificationService;

public class EmailService implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi email đến "+recipient+": "+message);
    }
}
