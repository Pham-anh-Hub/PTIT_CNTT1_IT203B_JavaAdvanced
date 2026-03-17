package PTIT_CNTT1_IT203B_Session07.Bai5.discount;

public class FixedDiscount implements  DiscountStrategy{

    @Override
    public double appyDiscount(double amount) {
        return amount - 50000;
    }
}
