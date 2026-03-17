package PTIT_CNTT1_IT203B_Session07.Bai2;


public class Main {
    public static void main(String[] args) {
        double orderTotal = 1000000; // Đơn hàng 1 triệu VNĐ
        System.out.println("Tổng tiền gốc: " + orderTotal);
        System.out.println("---------------------------------");

        // 1. Trường hợp không giảm giá
        DiscountStrategy noDiscount = new NoDiscount();
        double totalAfterDiscount = noDiscount.applyDiscount(orderTotal);
        System.out.println("Tổng tiền sau giảm giá: " + totalAfterDiscount);

        // 2. Trường hợp giảm theo phần trăm
        DiscountStrategy newPercentDiscount = new PercentageDiscount();
        double totalAfterPDiscount = newPercentDiscount.applyDiscount(orderTotal);
        System.out.println("Tổng tiền sau giảm giá(Theo %): " + totalAfterPDiscount);

        // 3. Trường hợp giảm cố định 50k
        DiscountStrategy newFixDiscount = new FixedDiscount();
        double totalAfterFDiscount = newFixDiscount.applyDiscount(orderTotal);
        System.out.println("Tổng tiền sau giảm giá(Cố định giá): " + totalAfterFDiscount);;

        // 4. Áp dụng HolidayDiscount mới tạo (Mở rộng mà không sửa code cũ)
        class HolidayDisCount implements DiscountStrategy{
            @Override
            public double applyDiscount(double totalAmount) {
                // Khuyến mãi cho ngày lễ
                if(totalAmount >= 300000){
                    return totalAmount * (100 - 15)/100;
                }else if(totalAmount >= 850000){
                    return totalAmount * (100 - 20)/ 100;
                }
                return totalAmount * (100-5)/100;
            }
        }

        DiscountStrategy newPayment = new HolidayDisCount();
        double totalAfterHDiscount = newPayment.applyDiscount(orderTotal);
        System.out.println("Tổng tiền sau giảm giá: " + totalAfterHDiscount);
    }
}