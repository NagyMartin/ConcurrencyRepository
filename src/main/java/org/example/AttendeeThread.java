package org.example;


import java.util.Random;

public class AttendeeThread extends Thread {

    protected FestivalGate festivalGate;
    protected Ticket ticketType;

    public Ticket getTicketType() {
        return ticketType;
    }

    public void setTicketType() {
        Random random = new Random();
        this.ticketType = Ticket.values()[random.nextInt(0, Ticket.values().length - 1)];
    }

    public AttendeeThread(Ticket ticketType, FestivalGate festivalGate) {
        this.ticketType = ticketType;
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
