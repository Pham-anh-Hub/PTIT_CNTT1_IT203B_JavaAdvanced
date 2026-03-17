package PTIT_CNTT1_IT203B_Session08.Bai5.observer;


import PTIT_CNTT1_IT203B_Session08.Bai5.Observer;

public class Fan implements Observer {

    public Fan() {
    }

    @Override
    public void update(int tempurature) {
        if(tempurature < 20){
            System.out.println("Quạt: Nhiệt độ thấp tự động tắt");
        }else{
            System.out.println("Quạt: Nhiệt độ cao, tăng tốc độ quạt");
        }
    }
}
