package PTIT_CNTT1_IT203B_Session07.Bai5.model;

import java.util.UUID;

public class Product {
    public String productId;
    public String productName;
    public double price;
    public int quantityInStock;

    public Product() {
    }

    public Product(String productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantityInStock = quantity;

    }
}
