package PTIT_CNTT1_IT203B_Session06.HeThongBanVePhimTrucTuyen;

import java.util.List;

public class TimeoutManager implements Runnable {

    private List<TicketPool> pools;

    public TimeoutManager(List<TicketPool> pools) {
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            for (TicketPool pool : pools) {
                pool.releaseExpiredTickets();
            }

            try {
                Thread.sleep(1000); // kiểm tra mỗi 1 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}