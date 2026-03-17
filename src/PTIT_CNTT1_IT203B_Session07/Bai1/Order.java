package PTIT_CNTT1_IT203B_Session07.Bai1;

import java.text.NumberFormat;
import java.util.*;

import static PTIT_CNTT1_IT203B_Session07.Bai1.OrderCalculator.calculateTotalOrder;

public class Order {
    public String orderId;
    public Customer customer;
    public Map<Product, Integer> products;
    public double totalOrder;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new HashMap<>();
        this.orderId = new StringBuilder().append("OR00").append(this.products.size() + 1).toString();

        this.totalOrder = 0;
    }

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.products = new HashMap<>();
    }

    public void addNewProduct(Product p){
        this.products.put(p, this.products.getOrDefault(p, 0) + 1);
    }

    public void printOrder(){
        System.out.println("==== THÔNG TIN ĐƠN HÀNG ====");
        System.out.println("Khách hàng: " + this.customer.getEmail());
        System.out.println("----------------------------");
        System.out.println("Sản phẩm: ");

        for (Product p : products.keySet()){
            System.out.println(p.productName + "  x" + products.get(p));
        }

        System.out.println("-------------------------------");
        NumberFormat nf = NumberFormat.getNumberInstance();
        System.out.println("Thành tiền: " + nf.format(calculateTotalOrder(this)) + " VND");
    }
}
