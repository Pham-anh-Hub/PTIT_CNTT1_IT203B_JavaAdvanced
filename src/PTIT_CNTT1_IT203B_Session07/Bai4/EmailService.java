package PTIT_CNTT1_IT203B_Session07.Bai4;

public class EmailService implements NotificationService{
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi " + recipient + message);
    }
}
