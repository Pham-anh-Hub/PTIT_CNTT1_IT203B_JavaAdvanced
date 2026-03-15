package PTIT_CNTT1_IT203B_Session06.MoRongQuayVeCoBan;


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
                System.out.println("Nhà cung cấp đã thêm: " + supplyCount + " vé");
            }
        }catch (InterruptedException e){
            System.err.println(e);;
        }
    }
}