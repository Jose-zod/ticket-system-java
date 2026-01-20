package com.jmartin.support.model;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private final int id;
    private String title;
    private String description;
    private TicketStatus status;
    private User createdBy;
    private User assignedTo;
    private LocalDateTime createdAt;

    public Ticket(String title, String description, User createdBy) {
        this.id = COUNTER.getAndIncrement();
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.status = TicketStatus.OPEN;
        this.createdAt = LocalDateTime.now();

    }

    public int getId() {
        return id;
    }

    public TicketStatus getStatus() {
        return status;
    }


    public void  assignTo(User user) {
        if (status == TicketStatus.CLOSED) {
            throw new IllegalStateException("Cannot assign closed ticket ");
        }
        this.assignedTo = user;
        this.status = TicketStatus.IN_PROGRESS;

    }

    public void close() {
        if (status == TicketStatus.CLOSED) {
            throw new IllegalStateException("Ticket already closed");
        }
        this.status = TicketStatus.CLOSED;
    }
}
