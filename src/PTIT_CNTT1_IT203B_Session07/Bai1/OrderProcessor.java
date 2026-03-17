package PTIT_CNTT1_IT203B_Session07.Bai1;

import java.util.*;

public class OrderProcessor {
    public static Scanner sc = new Scanner(System.in);
    public  static List<Product> products = new ArrayList<>();
    public static OrderRepository newORepo = new OrderRepository();
    public static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        // Tạo các sản phẩm
        Product newProduct1 = new Product("OR001", "Máy tính bảng", 12000000);
        Product newProduct2 = new Product("OR002", "Laptop", 32000000);
        Product newProduct3 = new Product("OR003", "Chuột Bluetooth", 350000);
        Product newProduct4 = new Product("OR004", "Tai nghe", 1200000);
        Product newProduct5 = new Product("OR005", "Máy tính cầm tay", 560000);
        products = List.of(newProduct1, newProduct2, newProduct3, newProduct4, newProduct5); // add vào danh sách

        // Tạo khách hàng
        Customer newCustomer1 = new Customer("nvaA@gmail.com", "Hanoi");
        Customer newCustomer2 = new Customer("nvb@gmail.com", "Hanoi");
        Customer newCustomer3 = new Customer("ttc@gmail.com", "Hanoi");
        customers = List.of(newCustomer1, newCustomer2, newCustomer3);


        // Tạo đơn hàng mới
        Order newOrder = new Order();
        newOrder.customer = newCustomer1;
        newOrder.addNewProduct(newProduct1);
        newOrder.addNewProduct(newProduct1);
        newOrder.addNewProduct(newProduct2);
        newOrder.addNewProduct(newProduct1);
        newOrder.addNewProduct(newProduct3);
        newOrder.printOrder();



    }


}
