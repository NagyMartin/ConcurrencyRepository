package org.example;

public class App {
    public static void main(String[] args) throws InterruptedException {

        FestivalGate gate = new FestivalGate();
        for (int i = 0; i < 100; i++) {
            AttendeeThread attendee = new AttendeeThread(null, gate);
            Thread thread = new Thread(attendee, "Thread: " + i);
            System.out.println("We are in thread: " + thread.getName());
            thread.start();
            thread.join();
        }
        FestivalStatisticThread statisticThread = new FestivalStatisticThread(gate);
        Thread thread1 = new Thread(statisticThread,"Statistic Thread.");
        thread1.start();
    }
}
