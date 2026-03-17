package PTIT_CNTT1_IT203B_Session07.BTTH.model;

public class Customer {
    private String cusId;
    private String cusName;
    private String email;

    public Customer() {
    }

    public Customer(String cusId, String cusName, String email) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.email = email;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
