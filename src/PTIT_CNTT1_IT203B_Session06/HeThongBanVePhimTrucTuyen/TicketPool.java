package PTIT_CNTT1_IT203B_Session06.HeThongBanVePhimTrucTuyen;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    // kho chứa - quản lý danh sách Ticket
    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int count) {
        this.roomName = roomName;
        for (int i=1; i<=count ; i++){
            Ticket newTicket = new Ticket(roomName + String.format("%03d", i), roomName);
            tickets.add(newTicket);
        }
    }

    public synchronized Ticket holdTicket(boolean isVIP) {

        while (true) {

            for (Ticket t : tickets) {

                if (!t.isHeld && !t.isSold) {

                    t.isHeld = true;
                    t.isVip = isVIP;
                    t.holdExpiryTime = System.currentTimeMillis() + 5000;

                    return t;
                }
            }

            // Nếu không có vé trống thì chờ
            try {
                System.out.println("Kho " + this.roomName + " hết vé, đang chờ vé...");
                wait(5000);
                if(getUnSoldTickets() == 0){
                    System.out.println("Dừng bán vé");
                    return null;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sellHeldTicket(Ticket ticket) {

        if (ticket != null && ticket.isHeld) {

            ticket.isHeld = false;
            ticket.isSold = true;

            notifyAll(); // đánh thức các quầy đang chờ
        }
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (t.isHeld && !t.isSold && now > t.holdExpiryTime) {

                System.out.println("TimeoutManager: Vé " + t.ticketId + " hết hạn giữ, đã trả lại kho");

                t.isHeld = false;

                notifyAll();
            }
        }
    }

    public int getUnSoldTickets(){
        int count=0;
        for (Ticket t : tickets){
            if (!t.isSold){
                count++;
            }
        }
        return count;
    }
}
