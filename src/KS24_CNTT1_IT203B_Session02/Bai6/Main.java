package KS24_CNTT1_IT203B_Session02.Bai6;

import KS24_CNTT1_IT203B_Session02.Bai4.User;

public class Main {
    public static void main(String[] args) {
        UserProcessor up  = (u) -> UserUtils.convertToUpperCase(u); // Sử dụng Lamda

        UserProcessor userProcessor = UserUtils::convertToUpperCase; // Áp dụng Method Expression

    }
}
