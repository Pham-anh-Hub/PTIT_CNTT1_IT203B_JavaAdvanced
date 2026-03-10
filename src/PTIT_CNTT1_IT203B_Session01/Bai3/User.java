package PTIT_CNTT1_IT203B_Session01.Bai3;

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
