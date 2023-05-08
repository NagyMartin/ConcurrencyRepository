package org.example;

/**
 * Statistics class used as a thread.
 * It has a constructor that accesses Festival Gate class in which ticket details are stored in a Queue.
 * The run method is overridden so that it can get into the Queue to get the information and to
 * count and print the object types stored in the Queue.
 */

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
                Counter counter = new Counter(0, 0, 0, 0, 0);
                System.out.println(festivalGate.gateTickets.size() + " people entered.");
                for (Ticket ticket : festivalGate.gateTickets) {
                    switch (ticket) {
                        case FULL -> counter.setFullCounter(counter.getFullCounter()+1);
                        case FULL_VIP -> counter.setFullVipCounter(counter.getFullVipCounter()+1);
                        case ONE_DAY -> counter.setOneDayCounter(counter.getOneDayCounter()+1);
                        case ONE_DAY_VIP -> counter.setOneDayVipCounter(counter.getOneDayVipCounter()+1);
                        case FREE_PASS -> counter.setFreePassCounter(counter.getFreePassCounter()+1);
                    }
                }
                System.out.println(counter.getFullCounter() + " people have full tickets.");
                System.out.println(counter.getFullVipCounter() + " people have full VIP tickets.");
                System.out.println(counter.getFreePassCounter() + " people have free passes tickets.");
                System.out.println(counter.getOneDayCounter() + " people have one day passes tickets.");
                System.out.println(counter.getOneDayVipCounter() + " people have one day VIP passes tickets.");
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

