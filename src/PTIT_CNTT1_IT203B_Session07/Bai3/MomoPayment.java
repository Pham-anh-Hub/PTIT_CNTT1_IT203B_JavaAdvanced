package PTIT_CNTT1_IT203B_Session07.Bai3;

import java.text.NumberFormat;

public class MomoPayment implements EWalletPayable{
    @Override
    public void doPayment(double amount) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Xử lý thanh toán MoMo: " + nf.format(amount) + " - Thành công");
    }
}
