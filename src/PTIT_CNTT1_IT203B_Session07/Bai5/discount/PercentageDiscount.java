package PTIT_CNTT1_IT203B_Session07.Bai5.discount;


public class PercentageDiscount implements DiscountStrategy {
    @Override
    public double appyDiscount(double amount) {
        if(amount >= 1000000){
            return amount * (100 - 10)/100;
        }
        return amount;
    }
}
