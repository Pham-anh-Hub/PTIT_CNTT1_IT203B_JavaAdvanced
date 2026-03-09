package KS24_CNTT1_IT203B_Session02.Bai5;

public interface UserActions {
    default void logActivity(String activity){
        System.out.println("Vừa thêm hành động: " + activity);
    }
}
