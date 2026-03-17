package PTIT_CNTT1_IT203B_Session07.BTTH.model;

public class Product {
    private String proId;
    private String proName;
    private double price;

    public Product() {
    }

    public Product(String proId, String proName, double price) {
        this.proId = proId;
        this.proName = proName;
        this.price = price;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
