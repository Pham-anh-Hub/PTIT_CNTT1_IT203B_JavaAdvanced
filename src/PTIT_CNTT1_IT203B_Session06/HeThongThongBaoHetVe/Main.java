package PTIT_CNTT1_IT203B_Session06.HeThongThongBaoHetVe;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketPool poolA = new TicketPool("A", 10);
        TicketPool poolB = new TicketPool("B", 10);

        BookingCounter counter1 = new BookingCounter("Quầy 1", poolA, poolB);
        BookingCounter counter2 = new BookingCounter("Quầy 2", poolA, poolB);

        TicketSupplier supplier = new TicketSupplier(poolA, poolB, 3, 3000, 2);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread supthread = new Thread(supplier);



        t1.start();
        t2.start();
        supthread.start();


        supthread.join();

        t1.join();// Đợi quầy 1 xong
        t2.join();// Đợi quầy 2 xong


        System.out.println("======================================");
        System.out.println("Quầy 1 bán được: " + counter1.getSoldCount() + " vé");
        System.out.println("Quầy 2 bán được: " + counter2.getSoldCount() + " vé");
        System.out.println("Tổng số vé đã bán được: " + (counter1.getSoldCount() + counter1.getSoldCount()) + " vé");

        System.out.println("Vé còn lại phòng A: " + poolA.getRemainingTickets());
        System.out.println("Vé còn lại phòng B: " + poolB.getRemainingTickets());


    }
}
