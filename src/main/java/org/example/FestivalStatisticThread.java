package org.example;

public class FestivalStatisticThread extends Thread {

    protected FestivalGate festivalGate;

    public FestivalStatisticThread(FestivalGate festivalGate) {

        this.festivalGate = festivalGate;
    }

    @Override
    public void run() {
        if (festivalGate.gateTickets == null) {
            throw new RuntimeException("The gate has not registered any ticket intake.");
        }
        try {
            synchronized (festivalGate.gateTickets) {
                int fullCounter = 0;
                int fullVipCounter = 0;
                int freePassCounter = 0;
                int oneDayCounter = 0;
                int oneDayVipCounter = 0;
                System.out.println(festivalGate.gateTickets.size() + " people entered.");
                for (Ticket ticket : festivalGate.gateTickets) {
                    if (ticket.equals(Ticket.FULL)) {
                        fullCounter++;
                    }
                    if (ticket.equals(Ticket.FULL_VIP)) {
                        fullVipCounter++;
                    }
                    if (ticket.equals(Ticket.FREE_PASS)) {
                        freePassCounter++;
                    }
                    if (ticket.equals(Ticket.ONE_DAY)) {
                        oneDayCounter++;
                    }
                    if (ticket.equals(Ticket.ONE_DAY_VIP)) {
                        oneDayVipCounter++;
                    }
                }
                System.out.println(fullCounter + " people have full tickets.");
                System.out.println(fullVipCounter + " people have full VIP tickets.");
                System.out.println(freePassCounter + " people have free passes tickets.");
                System.out.println(oneDayCounter + " people have one day passes tickets.");
                System.out.println(oneDayVipCounter + " people have one day VIP passes tickets.");
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
