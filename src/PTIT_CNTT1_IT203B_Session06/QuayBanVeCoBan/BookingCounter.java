    package PTIT_CNTT1_IT203B_Session06.QuayBanVeCoBan;

    import java.util.Random;

class BookingCounter implements Runnable {
    private String counterName;
    private TicketPool poolA;
    private TicketPool poolB;
    private int soldCount = 0;

    public BookingCounter(String counterName, TicketPool poolA, TicketPool poolB) {
        this.counterName = counterName;
        this.poolA = poolA;
        this.poolB = poolB;
    }

    @Override
    public void run() {
        // Random kho vé
        Random random = new Random();
        while (true){
            // Kiểm tra xem cả 2 phòng còn vé không
            if(poolA.getRemainingTickets() == 0 && poolB.getRemainingTickets() == 0){
                // cả hai phòng đều hết vé
                break;
            }

//            // 2. CỐ TÌNH NGHỈ TRƯỚC KHI BÁN để luồng kia có cơ hội nhảy vào
            try {
                // Nghỉ 500ms (0.5 giây) để bạn nhìn thấy tiến trình chậm lại
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Chọn random phòng (kho vé)
            int choice = random.nextInt(2);
            Ticket sold = null;

            // 0 - phòng A
            if(choice == 0){
                sold = poolA.sellTicket();
                // Phòng A hết vé, thử lại sang phòng B
                if(sold == null) {
                    sold = poolB.sellTicket();
                }
            }else{
                sold = poolB.sellTicket();
                if(sold == null) sold = poolA.sellTicket();
            }

            if(sold != null){
                soldCount++;
                System.out.println(counterName + " đã bán vé " + sold.ticketId);
            }
        }
    }

    // Lấy số lượng vé đã bán
    public int getSoldCount() {
        return soldCount;
    }
}