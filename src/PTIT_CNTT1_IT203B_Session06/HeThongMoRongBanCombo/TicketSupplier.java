package PTIT_CNTT1_IT203B_Session06.HeThongMoRongBanCombo;


public class TicketSupplier implements Runnable {

    public TicketPool poolA;
    public TicketPool poolB;

    private int supplyCount;
    private int interval;
    private int rounds;

    public TicketSupplier(TicketPool poolA, TicketPool poolB, int supplyCount, int interval, int rounds) {
        this.poolA = poolA;
        this.poolB = poolB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < rounds; i++) {
                Thread.sleep(interval);
                poolA.addTickets(supplyCount);
                poolB.addTickets(supplyCount);
                System.out.println("\nNhà cung cấp đã thêm: " + supplyCount + " vé");
            }
            // Đánh thức cả 2 phòng vé trước khi dừng lại
            System.out.println("\nNhà cung cấp chuẩn bị ngưng thêm vé..");
            poolA.finalNotify();
            poolB.finalNotify();

        }catch (InterruptedException e){
            System.err.println(e);;
        }
    }
}