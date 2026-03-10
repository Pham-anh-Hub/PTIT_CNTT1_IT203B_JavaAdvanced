package PTIT_CNTT1_IT203B_Session01.Bai5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            User user = new User();
            System.out.println("Nhập tuổi: ");
            int input = sc.nextInt();
            user.setAge(input);
        }catch (InvalidAgeException e){
            SimpleDateFormat sdf = new SimpleDateFormat();
            String time = sdf.format((new Date()));
            System.err.println(e.getMessage() + " | " + time);
        }
    }
}
