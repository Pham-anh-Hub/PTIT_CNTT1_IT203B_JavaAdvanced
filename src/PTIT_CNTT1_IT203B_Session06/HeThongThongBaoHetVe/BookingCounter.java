    package PTIT_CNTT1_IT203B_Session06.HeThongThongBaoHetVe;


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
            Random random = new Random();
            while (true) {
                int choice = random.nextInt(2);

                // Gọi sellTicket. Nếu hết vé, dòng code này sẽ "đứng im" chờ tại đây
                Ticket sold = (choice == 0) ? poolA.sellTicket() : poolB.sellTicket();

                if (sold != null) {
                    soldCount++;
                    System.out.println(counterName + " đã bán vé " + sold.ticketId);
                    try {
                        Thread.sleep(350); // Nghỉ để đan xen giữa các quầy
                    } catch (InterruptedException e) {
                        break; // Thoát vòng lặp nếu bị ngắt khi đang ngủ
                    }
                } else {
                    // Nếu sellTicket trả về null (do bị ngắt hoặc hết vé vĩnh viễn)
                    break;
                }
            }
        }


        // Lấy số lượng vé đã bán
        public int getSoldCount() {
            return soldCount;
        }
    }