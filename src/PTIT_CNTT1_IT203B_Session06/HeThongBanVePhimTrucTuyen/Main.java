package PTIT_CNTT1_IT203B_Session06.HeThongBanVePhimTrucTuyen;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Tạo các phòng chiếu
        TicketPool poolA = new TicketPool("A", 5);
        TicketPool poolB = new TicketPool("B", 5);
        TicketPool poolC = new TicketPool("C", 5);

        // Danh sách các pool
        List<TicketPool> pools = List.of(poolA, poolB, poolC);

        // Tạo TimeoutManager
        TimeoutManager manager = new TimeoutManager(pools);
        Thread timeoutThread = new Thread(manager);
        timeoutThread.start();

        // Tạo các quầy bán vé
        // Giả lập với 3
        BookingCounter c1 = new BookingCounter("Quầy 1", poolA, true);
        BookingCounter c2 = new BookingCounter("Quầy 2", poolB, false);
        BookingCounter c3 = new BookingCounter("Quầy 3", poolC, false);

        // Chạy các thread
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        t1.start();
        t2.start();
        t3.start();
    }
}