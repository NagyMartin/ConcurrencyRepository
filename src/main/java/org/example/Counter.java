package org.example;

/**
 * Counter class that is used in the Festival Statistic class run method, to keep
 * track of the ticket types.
 */

public class Counter {
    private int fullCounter;
    private int fullVipCounter;
    private int freePassCounter;
    private int oneDayCounter;
    private int oneDayVipCounter;

    public Counter(int fullCounter, int fullVipCounter, int freePassCounter, int oneDayCounter, int oneDayVipCounter) {
        this.fullCounter = fullCounter;
        this.fullVipCounter = fullVipCounter;
        this.freePassCounter = freePassCounter;
        this.oneDayCounter = oneDayCounter;
        this.oneDayVipCounter = oneDayVipCounter;
    }

    public int getFullCounter() {
        return fullCounter;
    }

    public void setFullCounter(int fullCounter) {
        this.fullCounter = fullCounter;
    }

    public int getFullVipCounter() {
        return fullVipCounter;
    }

    public void setFullVipCounter(int fullVipCounter) {
        this.fullVipCounter = fullVipCounter;
    }

    public int getFreePassCounter() {
        return freePassCounter;
    }

    public void setFreePassCounter(int freePassCounter) {
        this.freePassCounter = freePassCounter;
    }

    public int getOneDayCounter() {
        return oneDayCounter;
    }

    public void setOneDayCounter(int oneDayCounter) {
        this.oneDayCounter = oneDayCounter;
    }

    public int getOneDayVipCounter() {
        return oneDayVipCounter;
    }

    public void setOneDayVipCounter(int oneDayVipCounter) {
        this.oneDayVipCounter = oneDayVipCounter;
    }
}
