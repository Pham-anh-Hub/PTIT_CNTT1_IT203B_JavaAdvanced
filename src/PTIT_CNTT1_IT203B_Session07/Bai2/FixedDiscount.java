package PTIT_CNTT1_IT203B_Session07.Bai2;

public class FixedDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double totalAmount) {
        if(totalAmount >= 1000000){
            return totalAmount - 50000;
        }
        return totalAmount;
    }
}
