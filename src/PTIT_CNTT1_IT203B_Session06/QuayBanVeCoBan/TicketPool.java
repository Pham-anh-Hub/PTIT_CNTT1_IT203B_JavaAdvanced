package PTIT_CNTT1_IT203B_Session06.QuayBanVeCoBan;

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
        for (Ticket t : tickets){
            if(!t.isSold){
                t.isSold = true;
                return t;
            }
        }
        return null; // vé trong kho này đã hết
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
}

