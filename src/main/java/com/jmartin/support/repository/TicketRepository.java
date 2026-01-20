package com.jmartin.support.repository;

import com.jmartin.support.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketRepository {

    private final List<Ticket> tickets = new ArrayList<>();

    public void save(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }
        tickets.add(ticket);
    }

    public Optional<Ticket> findById(int id) {
        return tickets.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }
}
