    package PTIT_CNTT1_IT203B_Session06.MoRongQuayVeCoBan;

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


            // Chọn random phòng (kho vé)
            int choice = random.nextInt(2);
            Ticket sold = null;
            System.out.println(choice);

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
                try{
                    // tạm nghỉ để thay phiên bán giữa 2 quầy
                    Thread.sleep(350);
                }catch (InterruptedException e){
                    System.err.println(e.toString());
                }
            }else{
                // nếu không lấy được vé, tạm thời hết
                // kiểm tra xem có hết vé ở cả 2 phòng không
                if(poolA.getRemainingTickets() == 0 && poolB.getRemainingTickets() == 0){
                    // đợi 1 lúc xem có vé mới được nạp thêm không
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    // sau khi đợi mà không có thêm vé --> thoát vòng lặp bán
                    if(poolA.getRemainingTickets() == 0 && poolB.getRemainingTickets() == 0){
                        break;
                    }
                }
            }
        }
    }

    // Lấy số lượng vé đã bán
    public int getSoldCount() {
        return soldCount;
    }
}