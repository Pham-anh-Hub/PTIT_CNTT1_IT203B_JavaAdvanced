package PTIT_CNTT1_IT203B_Session07.Bai3;

import java.text.NumberFormat;

public interface CODPayable extends PaymentMethod {
    void doPayment(double amount);
}
