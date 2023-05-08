package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger("concurrencyAppLogger");

    public static void main(String[] args) {

        logger.info("Starting app.");
        FestivalGate gate = new FestivalGate();
        for (int i = 0; i < 100; i++) {
            AttendeeThread attendee = new AttendeeThread(gate);
            Thread thread = new Thread(attendee, "Thread: " + i);
            System.out.println("We are in thread: " + thread.getName());
            thread.start();
        }
        FestivalStatisticThread statisticThread = new FestivalStatisticThread(gate);
        Thread thread1 = new Thread(statisticThread, "Statistic Thread.");
        try {
            thread1.start();
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, "Error during run.", e);
            throw new RuntimeException(e.getLocalizedMessage());
        }
        logger.info("Ending app.");
    }
}
