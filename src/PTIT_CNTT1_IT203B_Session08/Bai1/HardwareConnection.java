package PTIT_CNTT1_IT203B_Session08.Bai1;

public class HardwareConnection {
    private static HardwareConnection instance;
    public HardwareConnection() {
    }

    public static HardwareConnection getInstance(){
        if (instance==null){
            instance = new HardwareConnection();
        }
        return instance;
    }

    void connect(){
        System.out.println("Đã kết nối phần cứng!!");
    }

    void disconnect(){
        System.out.println("Đã ngắt kết nối phần cứng!!");
    }
}
