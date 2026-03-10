package PTIT_CNTT1_IT203B_Session03;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bai1 {
    public record User(String username, String email, String status){
        @Override
        public String toString() {
            return username + " | " + email + " | " + status;
        }
    };

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("alice", "alice@gmail.com", "STATUS"));
        users.add(new User("bob", "bob@gmail.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "STATUS"));


        users.forEach(System.out::println);



    }
}
