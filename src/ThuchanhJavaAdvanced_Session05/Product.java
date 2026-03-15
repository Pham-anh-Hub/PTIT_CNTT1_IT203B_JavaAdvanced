package ThuchanhJavaAdvanced_Session05;

public class Product {
    private int id;
    public String name;
    public double price;
    public int quantity;
    public String category;

    public Product() {
    }

    public Product(int id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getId() + " | Danh mục: " + this.category + " | " + this.name + " | " + this.price + " | Số lượng tồn: " + this.quantity;
    }
}
