package PTIT_CNTT1_IT203B_Session06.HeThongBanVePhimTrucTuyen;

public class Ticket {
    public String ticketId;
    public String roomName;
    public boolean isSold;
    public boolean isHeld; // co khach nao ddang giu khong
    public boolean isVip;
    public long holdExpiryTime; // int không đủ để lưu timestamp

    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = false;
        this.isHeld = false;
        this.isVip = false;
        this.holdExpiryTime = 10000; // cho phep giu ve trong 10s
    }

}
