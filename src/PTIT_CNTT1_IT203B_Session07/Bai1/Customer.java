package PTIT_CNTT1_IT203B_Session07.Bai1;

import java.util.UUID;

public class Customer {
    public String customerId;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(String email, String address) {
        this.customerId = UUID.randomUUID().toString();
        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
