package PTIT_CNTT1_IT203B_Session06.ThuchanhDemo;

import java.util.ArrayList;
import java.util.List;

public class Luong1 {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        students = List.of(
                "Đặng Quốc Toàn 05/02/2006",
                "Hưng Nguyễn Thạc",
                "Nguyễn Khắc Phong-26-3-2006",
                "Trần Minh Quang 04-07-2006",
                "Đinh Trọng An-25/12/2006",
                "Lê Duy Minh_20/03/2006",
                "Mai Duy Anh - 07/04/2006", "Lê Tiến Đức-5/4/2006", "Đinh Đình Thành 14-03-2006");

        while (true){
            try{
                int random = Integer.parseInt(String.valueOf(Math.round(Math.random() * 6)));
                System.out.println(students.get(random));
                Thread.sleep(1000);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }


}
