package KS24_CNTT1_IT203B_Session02.Bai4;

public class User {
    String username;
    int age;
    String gender;

    public User() {
    }

    public User(String username, int age, String gender) {
        this.username = username;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return username + " | " + age + " | " + gender;
    }
}
