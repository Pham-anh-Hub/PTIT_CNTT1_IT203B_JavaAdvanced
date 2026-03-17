package PTIT_CNTT1_IT203B_Session07.Bai1;

public class EmailService {

    public void sendConfirmEmail(String cEmail, String orderId){
        System.out.println("Đã gửi email đến " + cEmail + ": Đơn hàng "+ orderId + " đã được tạo");
    }
}
