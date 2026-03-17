package PTIT_CNTT1_IT203B_Session07.BTTH.service;

import PTIT_CNTT1_IT203B_Session07.BTTH.discount.DiscountStrategy;
import PTIT_CNTT1_IT203B_Session07.BTTH.discount.impl.FixedDiscount;
import PTIT_CNTT1_IT203B_Session07.BTTH.discount.impl.PercentageDiscount;
import PTIT_CNTT1_IT203B_Session07.BTTH.model.Order;
import PTIT_CNTT1_IT203B_Session07.BTTH.notification.NotificationService;
import PTIT_CNTT1_IT203B_Session07.BTTH.notification.impl.EmailService;
import PTIT_CNTT1_IT203B_Session07.BTTH.payment.PaymentMethod;
import PTIT_CNTT1_IT203B_Session07.BTTH.payment.impl.CODPayment;
import PTIT_CNTT1_IT203B_Session07.BTTH.payment.impl.CreditCardPayment;
import PTIT_CNTT1_IT203B_Session07.BTTH.repository.OrderRepository;
import PTIT_CNTT1_IT203B_Session07.BTTH.repository.impl.FileOrderRepository;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.UUID;

public class OrderService {
    private DiscountStrategy  discountStrategy;
    private PaymentMethod  paymentMethod;
    private NotificationService notificationService;
    private OrderRepository orderRepository;

    public OrderService() {
    }

    public OrderService(DiscountStrategy discountStrategy, PaymentMethod paymentMethod, NotificationService notificationService, OrderRepository orderRepository) {
        this.discountStrategy = discountStrategy;
        this.paymentMethod = paymentMethod;
        this.notificationService = notificationService;
        this.orderRepository = orderRepository;
    }

    public void processOrder(Order order){
        String cusName, email;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng: ");
        cusName = sc.nextLine();
        System.out.println("Nhập email: ");
        email = sc.nextLine();

        System.out.println("Nhập tổng tiền cho đơn hàng: ");
        Order od = new Order();
        od.setOrderId(UUID.randomUUID().toString());
        od.setCustomerName(cusName);
        od.setEmail(email);
        od.setTotalMoneys(Double.parseDouble(sc.nextLine()));

        //Chọn loại giảm giá
        System.out.println("Chọn loại giảm giá: ");
        System.out.println("Giảm 10% (nếu > 1 triệu)");
        System.out.println("Giảm 50000 cố định");
        int anser = Integer.parseInt(sc.nextLine());

        double discountMoney = 0;

        switch(anser){
            case 1:
                //giảm theo %
                discountStrategy = new PercentageDiscount(0.1);
                discountMoney = discountStrategy.applyDiscount(od.getTotalMoneys());
                break;
            case 2:
                //giảm cố định
                discountStrategy = new FixedDiscount(50000);
                discountMoney = discountStrategy.applyDiscount(od.getTotalMoneys());
                break;
            case 3:
                //không giảm
            default:
                System.out.println("Bạn chọn giảm giá không đúng!");
                System.exit(0);
        }

        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Tổng tiền: "+nf.format(od.getTotalMoneys()));
        System.out.println("Sau khi giảm giá: "+nf.format(od.getTotalMoneys()-discountMoney));

        //Chọn phương thức thanh toán
        System.out.println("Chọn phương thức thanh toán \n1. COD \n2. Thẻ tín dụng \nChọn:");
        int methodPayment = Integer.parseInt(sc.nextLine());
        switch (methodPayment){
            case 1:
                //Thanh toán theo COD
                paymentMethod = new CODPayment();
                paymentMethod.process(od.getTotalMoneys()-discountMoney);
                break;
            case 2:
                //Thanh toán theo thẻ tín dụng
                paymentMethod = new CreditCardPayment();
                paymentMethod.process(od.getTotalMoneys()-discountMoney);
                break;
            default:
                System.out.println("Chọn sai phương thức thanh toán!");
                System.exit(0);
        }

        orderRepository = new FileOrderRepository();
        orderRepository.save(od);

        notificationService = new EmailService();
        notificationService.send("Đơn hàng của bạn đã được xác nhận.",od.getEmail());


    }
}
