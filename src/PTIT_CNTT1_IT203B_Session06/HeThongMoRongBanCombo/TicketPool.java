package PTIT_CNTT1_IT203B_Session06.HeThongMoRongBanCombo;


import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int count) {
        this.roomName = roomName;
        // Khởi tạo và thêm số vé ban đầu
        for (int i=1; i<=count; i++){
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", i), roomName));
        }
    }

    // Hàm lấy vé ngay lập tức, nếu hết thì trả về null chứ không wait()
    public synchronized Ticket sellTicketNoWait() {
        for (Ticket t : tickets) {
            if (!t.isSold) {
                t.isSold = true;
                return t;
            }
        }
        System.out.println("Phòng " + this.roomName + " hết vé...");
        return null;
    }

    // Phương thức cung cấp thêm vé vào kho
    public synchronized void addTickets(int count){
        // Lấy ID tiếp theo để theem vào dựa trên tổng số vé hiện có
        int currentSize = tickets.size();
        for (int i = 1; i <=count ; i++) {
            String newId = roomName + "-" + String.format("%03d (vé mới)", currentSize+i);
            tickets.add(new Ticket(newId, roomName));
        }
        // Thông báo cho các quầy đang chờ wait() rằng đã cấp thêm vé
        notifyAll();
    }

    // Đếm số lượng vé chưa bán còn lại
    public synchronized int getRemainingTickets(){
        int count = 0;
        for (Ticket t : tickets){
            if(!t.isSold){
                count++;
            }
        }
        return count;
    }

    public synchronized void finalNotify(){
        notifyAll();
    }
}


