package PTIT_CNTT1_IT203B_Session07.Bai5;

import PTIT_CNTT1_IT203B_Session07.Bai5.discount.DiscountStrategy;
import PTIT_CNTT1_IT203B_Session07.Bai5.discount.FixedDiscount;
import PTIT_CNTT1_IT203B_Session07.Bai5.discount.HolidayDiscount;
import PTIT_CNTT1_IT203B_Session07.Bai5.discount.PercentageDiscount;
import PTIT_CNTT1_IT203B_Session07.Bai5.model.Customer;
import PTIT_CNTT1_IT203B_Session07.Bai5.model.Order;
import PTIT_CNTT1_IT203B_Session07.Bai5.model.OrderItem;
import PTIT_CNTT1_IT203B_Session07.Bai5.model.Product;
import PTIT_CNTT1_IT203B_Session07.Bai5.notice.EmailNotification;
import PTIT_CNTT1_IT203B_Session07.Bai5.notice.NotificationService;
import PTIT_CNTT1_IT203B_Session07.Bai5.orderRepo.FileOrderRepository;
import PTIT_CNTT1_IT203B_Session07.Bai5.orderRepo.OrderRepository;
import PTIT_CNTT1_IT203B_Session07.Bai5.payment.*;

import java.lang.annotation.Target;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();
    private static List<Customer> customerList = new ArrayList<>();
    private static List<Order> orderList = new ArrayList<>();

    // Khởi tạo Service
    private static OrderRepository repository = new FileOrderRepository();
    private static NotificationService notificationService = new EmailNotification();
    private static OrderService orderService = new OrderService(repository, notificationService);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    createNewOrder();
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    calculateRevenue();
                    break;
                case 6:
                    System.out.println("Tính năng: Thêm phương thức thanh toán mới ");
                    System.out.println("Chọn phương thức thanh toán mới: ");
                    String pChoice = sc.nextLine();

                    class newPayment implements PaymentMethod{
                        @Override
                        public void doPayment(double amount) {

                        }
                    };
                    break;
                case 7:
                    System.out.println("Tính năng: Thêm chiến lược giảm giá mới");
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    sc.close();
                    break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void printMenu() {
        System.out.println("\n========= HỆ THỐNG QUẢN LÝ ĐƠN HÀNG =========");
        System.out.println("1. Thêm sản phẩm mới");
        System.out.println("2. Thêm khách hàng mới");
        System.out.println("3. Tạo đơn hàng mới");
        System.out.println("4. Xem danh sách đơn hàng");
        System.out.println("5. Tính tổng doanh thu");
        System.out.println("6. Mở rộng phương thức thanh toán");
        System.out.println("7. Mở rộng chiến lược giảm giá");
        System.out.println("0. Thoát");
        System.out.println("=============================================");
    }

    // 1. Thêm sản phẩm
    private static void addProduct() {
        String productId;
        boolean idExisted = false;
        while(true){
            productId = "PR" + String.format("%03d", Math.round(Math.random() * 1000));
            for(Product p : productList){
                if(p.productId.equals(productId)){
                    idExisted = true;
                }
            }
            if(!idExisted){
                break;
            }
        }
        System.out.print("Nhập tên sản phẩm: "); String name = sc.nextLine();
        System.out.print("Nhập giá: "); double price = sc.nextDouble();
        System.out.print("Số lượng nhập: "); int quantityStock = sc.nextInt();
        sc.nextLine();
        Product p = new Product(productId, name, price, quantityStock); // ID tự tạo UUID trong constructor của bạn
        productList.add(p);
        System.out.println("Thêm sản phẩm thành công!");
    }

    // 2. Thêm khách hàng
    private static void addCustomer() {
        System.out.print("Tên: "); String name = scanner.nextLine();
        System.out.print("SĐT: "); String phone = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Địa chỉ: "); String address = scanner.nextLine();
        customerList.add(new Customer(name, email, phone, address));
        System.out.println("Thêm khách hàng thành công!");
    }

    // 3. Tạo đơn hàng (Kết hợp chọn SP, Giảm giá, Thanh toán)
    private static void createNewOrder() {
        if (productList.isEmpty()) {
            System.out.println("Thông báo: Cần có ít nhất 1 sản phẩm trong kho!");
            return;
        }

        // Chọn khách hàng
        Customer selectedCustomer = new Customer();
        System.out.println("Chọn khách hàng theo SDT: ");
        String cPhone = sc.nextLine();
        for(Customer customer : customerList) {
            if(customer.phone.equals(cPhone)){
                selectedCustomer = customer;
            }
        }



        Order newOrder = new Order(selectedCustomer);

        // Chọn sản phẩm
        boolean shopping = true;
        while(shopping) {
            Product target = new Product();
            System.out.println("Chọn sản phẩm (ID): ");
            String id = sc.nextLine();
            for(Product p : productList) {
                if(p.productId.equals(id)){
                    target = p;
                }
            }

            System.out.print("Số lượng: ");
            int qty = Integer.parseInt(scanner.nextLine());

            newOrder.productMap.add(new OrderItem(target, qty));

            System.out.print("Mua tiếp? (y/n): ");
            if(scanner.nextLine().equalsIgnoreCase("n")) shopping = false;
        }

        // Chọn giảm giá
        System.out.println("Chọn giảm giá: 1. Không | 2. Giảm với phần trăm | 3. Khuyến mãi ngày lễ ");
        int dType = Integer.parseInt(scanner.nextLine());
        // Phần trăm giảm giá được áp dụng sẵn

        DiscountStrategy strategy = (dType == 1) ? new FixedDiscount() : (dType == 2) ? new PercentageDiscount() : new HolidayDiscount();

        double finalAmount = strategy.appyDiscount(calculateTotal(newOrder));

        // Chọn thanh toán
        System.out.println("Tổng tiền: " + finalAmount);

        boolean paid = false;
        while (!paid){
            System.out.println("Thanh toán: \n1. Thanh toán COD  \n2. CreditCard \n3. MoMo \n4. VNPay ");
            System.out.println("============================");
            int pType = Integer.parseInt(scanner.nextLine());

            switch (pType){
                case 1:
                    PaymentMethod pCod = new CODPayment();
                    pCod.doPayment(finalAmount);
                    newOrder.status = true;
                    break;
                case 2:
                    PaymentMethod pCreadit = new CreditCardPayment();
                    pCreadit.doPayment(finalAmount);
                    break;
                case 3:
                    PaymentMethod pMomo = new MomoPayment();
                    pMomo.doPayment(finalAmount);
                    break;
                case 4:
                    PaymentMethod vnPay = new VNPayPayment();
                    vnPay.doPayment(finalAmount);
                    break;
                default:
                    System.out.println("Phương thức thanh toán không hợp lệ!");
            }
        }


        // Hoàn tất
        newOrder.status = true; // Đã thanh toán
        orderList.add(newOrder);
        System.out.println("Tạo đơn hàng " + newOrder.pId + " thành công!");
        orderService.createOrder(newOrder, selectedCustomer);
    }

    private static void viewOrders() {
        for (Order o : orderList) {
            System.out.println("Mã ĐH: " + o.pId + " | Khách: " + o.customer.name + " | Trạng thái: " + (o.status ? "Đã thanh toán" : "Chưa"));
        }
    }

    private static void calculateRevenue() {
        double total = 0;
        for (Order o : orderList) {
            total += calculateTotal(o);
        }
        System.out.println("Tổng doanh thu hệ thống: " + total);
    }

    private static double calculateTotal(Order o) {
        double sum = 0;
        for(OrderItem item : o.productMap) sum += item.product.price * item.quantity;
        return sum;
    }
}