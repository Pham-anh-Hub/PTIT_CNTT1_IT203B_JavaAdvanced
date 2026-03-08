package CNTT1_IT203B_Session1.Bai3;

import CNTT1_IT203B_Session1.Bai5.InvalidAgeException;

public class User {
    int age;

    public User() {
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Tuổi không thể âm");
        }else{
            this.age = age;
            System.out.println("Gán thông tin tuổi thành công");
        }
    }
}
