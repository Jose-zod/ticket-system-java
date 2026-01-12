package com.jmartin.support.service;

import com.jmartin.support.model.Ticket;
import com.jmartin.support.model.TicketStatus;
import com.jmartin.support.model.User;
import com.jmartin.support.repository.TicketRepository;


public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService () {
        this.ticketRepository = new TicketRepository();
    }

    public int createTicket(String title, String description, User createdBy) {

        Ticket ticket = new Ticket(
                title,
                description,
                createdBy,
                TicketStatus.OPEN
        );
        ticketRepository.save(ticket);
        return ticket.getId();
    }
}
