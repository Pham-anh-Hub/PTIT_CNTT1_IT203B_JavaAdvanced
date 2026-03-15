package PTIT_CNTT1_IT203B_Session06.HeThongBanVePhimTrucTuyen;

public class BookingCounter implements Runnable {
    public String counterName;
    public TicketPool pool;
    public boolean isVIP;

    public BookingCounter(String counterName, TicketPool pool, boolean isVIP) {
        this.counterName = counterName;
        this.pool = pool;
        this.isVIP = isVIP;
    }

    @Override
    public void run() {

        while(true){

            Ticket ticket = pool.holdTicket(isVIP);

            if(ticket == null){
                System.out.println(counterName + ": Không lấy được vé, dừng bán");
                break;
            }

            System.out.println(counterName + ": Đã giữ vé " + ticket.ticketId);

            try {
                Thread.sleep(3000);
            } catch (Exception e) {}

            pool.sellHeldTicket(ticket);

            System.out.println(counterName + ": Thanh toán thành công vé " + ticket.ticketId);
        }
    }
}
