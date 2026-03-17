package PTIT_CNTT1_IT203B_Session07.Bai5.discount;

public class HolidayDiscount implements DiscountStrategy{
    @Override
    public double appyDiscount(double amount) {
        // Khuyến mãi cho ngày lễ
        if(amount >= 300000){
            return amount * (100 - 15)/100;
        }else if(amount >= 850000){
            return amount * (100 - 20)/ 100;
        }
        return amount * (100-5)/100;
    }
}
