package CNTT1_IT203B_Session1;

public class User {
    int age;

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalAccessException()
        }
        this.age = age;
    }
}
