package PTIT_CNTT1_IT203B_Session03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    // Sử dụng record User từ bài 1
    static List<Bai1.User> users = new ArrayList<>() ;
    static Optional<Bai1.User> findUserByUsername(String username){
        return users.stream().filter((Bai1.User u) -> u.username().equals(username)).findFirst() ;
    };

    public static void main(String[] args) {
        users.add(new Bai1.User("alice", "alice@gmail.com", "STATUS"));
        users.add(new Bai1.User("bob", "bob@yahoo.com", "INACTIVE"));
        users.add(new Bai1.User("charlie", "charlie@gmail.com", "STATUS"));

        Optional<Bai1.User> result = findUserByUsername("alice");
        if(result.isEmpty()){
            System.out.println("Quest login");
        }else{
            System.out.println("Welcome alice");
        }

    }
}
