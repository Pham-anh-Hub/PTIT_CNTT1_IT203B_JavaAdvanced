package PTIT_CNTT1_IT203B_Session07.Bai5.model;

public class Customer {
    public String customerId;
    public String name;
    public String email;
    public String phone;
    public String address;

    public Customer() {
    }

    public Customer(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.customerId = "C" + String.format("%04d", Integer.parseInt(phone.substring(this.phone.length() - 3, this.phone.length())));

    }
}
