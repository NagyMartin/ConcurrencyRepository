package org.example;

/**
 * Attendee class used as a thread.
 * It has a constructor that accesses the Festival Gate class in which ticket details are stored in a Queue.
 * The run method is overridden so that it can get into the Queue to enter the types of Tickets which are
 * stored in the Queue.
 * The setter method is used in the run method to randomize the ticket type which the Attendee object has.
 */


import java.util.Random;

public class AttendeeThread extends Thread {

    protected FestivalGate festivalGate;
    protected Ticket ticketType;

    public void setTicketType() {
        Random random = new Random();
        this.ticketType = Ticket.values()[random.nextInt(0, Ticket.values().length - 1)];
    }

    public AttendeeThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    @Override
    public void run() {
        try {
            setTicketType();
            synchronized (festivalGate.gateTickets) {
                festivalGate.gateTickets.add(ticketType);
            }
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
