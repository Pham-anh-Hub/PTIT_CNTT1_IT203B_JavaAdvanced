package KS24_CNTT1_IT203B_Session02.Bai6;

import KS24_CNTT1_IT203B_Session02.Bai4.User;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        UserProcessor up  = (u) -> UserUtils.convertToUpperCase(u); // Sử dụng Lamda

        UserProcessor userProcessor = UserUtils::convertToUpperCase; // Áp dụng Method Expression

        User newUser = new User("Nguyen Van A", 20, "Nam");
        Supplier<String> supplier = newUser::toString;
        System.out.println(supplier.get());

        String result = userProcessor.process(newUser);
        System.out.println(result);
    }
}
