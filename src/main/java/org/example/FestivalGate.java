package org.example;

/**
 * Festival Gate class in which has a Queue property of Ticket class type that stores
 * ticket information received from the Attendee class objects.
 */

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {

    final Queue<Ticket> gateTickets = new LinkedList<>();

}
