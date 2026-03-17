package PTIT_CNTT1_IT203B_Session07.Bai5.payment;

import java.text.NumberFormat;

public class CreditCardPayment implements PaymentMethod{
    @Override
    public void doPayment(double amount) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Thanh toán với thẻ tín dụng: " + amount + "VND - Thành công");
    }
}
