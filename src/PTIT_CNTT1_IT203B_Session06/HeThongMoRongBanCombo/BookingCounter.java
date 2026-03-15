    package PTIT_CNTT1_IT203B_Session06.HeThongMoRongBanCombo;


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
            while (true){
                boolean sellSuccess = sellCombo();
                if (sellSuccess){
                    try{
                        // tạm nghỉ để thấy giao dich rõ ràng
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        break;
                    }
                }else{
                    System.out.println("Dừng bán combo");
                    break;
                }
            }
        }

        // Trường hợp gây ra Deadlock
//        public boolean sellCombo() {
//            if (counterName.equals("Quầy 1")) {
//                synchronized (poolA) {
//                    try { Thread.sleep(100); } catch (InterruptedException e) {} // Chờ Quầy 2 giữ B
//                    synchronized (poolB) {
//                        // logic bán...
//                    }
//                }
//            } else {
//                // Quầy 2 làm ngược lại: Khóa B trước, A sau
//                synchronized (poolB) {
//                    try { Thread.sleep(100); } catch (InterruptedException e) {} // Chờ Quầy 1 giữ A
//                    synchronized (poolA) {
//                        // logic bán...
//                    }
//                }
//            }
//            return false; // Trả về false để tránh lỗi biên dịch, thực tế sẽ bị treo ở trên
//        }

        // Trường hợp bán tránh Deaklock
        public boolean sellCombo() {
            // Luôn khóa A trước, B sau (A < B)
            synchronized (poolA) {
                System.out.println(counterName + " đang kiểm tra phòng A...");
                Ticket vA = poolA.sellTicketNoWait(); // Dùng hàm lấy vé không chờ
                synchronized (poolB) {
                    System.out.println(counterName + " đang kiểm tra phòng B...");
                    Ticket vB = poolB.sellTicketNoWait();

                    if (vA != null && vB != null) {
                        soldCount++;
                        System.out.println(counterName + " bán COMBO thành công: " + vA.ticketId + " & " + vB.ticketId + "\n");
                        return true;
                    } else {
                        System.out.println(counterName + " bán combo thất bại (Hết vé)\n");
                        return false;
                        // Nếu lấy được 1 cái mà cái kia hết, logic sellTicket của bạn
                        // nên có phần trả lại vé hoặc dùng kiểm tra getRemainingTickets trước.
                    }
                }
            }
        }


//         Lấy số lượng vé đã bán
        public int getSoldCount() {
            return soldCount;
        }
    }