package PTIT_CNTT1_IT203B_Session06.HeThongThongBaoHetVe;

public class Ticket {
    public String ticketId;
    public String roomName;
    public boolean isSold;

    public Ticket() {
    }

    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = false; // Ban đầu khi vừa khởi tạo - vé còn
    }
}
