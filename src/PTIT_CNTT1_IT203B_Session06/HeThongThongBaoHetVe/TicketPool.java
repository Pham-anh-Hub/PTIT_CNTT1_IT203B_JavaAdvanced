package PTIT_CNTT1_IT203B_Session06.HeThongThongBaoHetVe;


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

    // Phương thức đồng bộ: Chỉ 1 quầy được lấy vé trong kho tại 1 thời điềm
    public synchronized Ticket sellTicket(){
        while (getRemainingTickets() == 0){
            try{
                System.out.println("\nPhòng " + this.roomName + " hết vé, đang đợi vé mới...");
                wait(5000); // chờ đến khi được cung cấp thêm vé
                if(getRemainingTickets() == 0){
                    return null;
                }
            } catch (InterruptedException e) {
                return null; // trả về null để quầy beists là không còn vé để chờ
            }
        }
        // Được gọi dậy --> tiếp tục bán vé
        for (Ticket t : tickets){
            if(!t.isSold){
                t.isSold = true;
                return t;
            }
        }
        return null; // vé trong kho này đã hết
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


