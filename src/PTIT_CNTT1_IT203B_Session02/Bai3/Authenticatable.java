package PTIT_CNTT1_IT203B_Session02.Bai3;

public interface Authenticatable {
    abstract String getPassword();

    default boolean isAuthenticated(){
//        encrypt(this.getPassword());
        return this.getPassword().isEmpty();
    }

    static String encrypt(String rawPassword){
        return rawPassword; // Thêm logic mã hóa mật khẩu
    }

}
