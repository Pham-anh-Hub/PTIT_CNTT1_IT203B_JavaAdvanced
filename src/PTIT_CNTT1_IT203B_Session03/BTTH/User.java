package PTIT_CNTT1_IT203B_Session03.BTTH;

import java.time.LocalDate;

public class User {

    public String id;
    protected String email;
    private String pasword;
    public boolean verified;
    public LocalDate createdAt;

    public User(String id, String email, String pasword, boolean verified, LocalDate createdAt) {
        this.id = id;
        this.email = email;
        this.pasword = pasword;
        this.verified = verified;
        this.createdAt = LocalDate.now();
    }

}
