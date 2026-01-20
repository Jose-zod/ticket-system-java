package com.jmartin.support.service;

import com.jmartin.support.model.RoundRobinStatus;
import com.jmartin.support.model.Ticket;
import com.jmartin.support.model.User;
import com.jmartin.support.model.UserType;
import com.jmartin.support.repository.TicketRepository;
import java.util.List;

import java.util.Optional;


public class TicketService {
private int currentIndex ;
private final List<User> agents;

    private final TicketRepository ticketRepository;


    public TicketService (List<User> agents) {
        this.ticketRepository = new TicketRepository();
        this.agents = agents;
        this.currentIndex = 0;
    }


    public int createTicket(String title, String description, User createdBy) {

        Ticket ticket = new Ticket(
                title,
                description,
                createdBy );

        ticketRepository.save(ticket);
        return ticket.getId();
    }
public RoundRobinResult roundRobin(int ticketId) {
    Optional<Ticket> ticket = ticketRepository.findById(ticketId);
    if (ticket.isEmpty()) {
        return new RoundRobinResult(RoundRobinStatus.TICKET_NOT_FOUND, null);}

        if (agents.isEmpty()) {
            return new RoundRobinResult(RoundRobinStatus.NO_AGENTS, null);
        }
        User agentAssigned = agents.get(currentIndex);
        currentIndex = (currentIndex + 1) % agents.size();

        if (agentAssigned.getType() != UserType.AGENT) {
            return new RoundRobinResult(RoundRobinStatus.INVALID_AGENT, null);
        }
        Ticket ticketToAssigned = ticket.get();
        ticketToAssigned.assignTo(agentAssigned);
        return new RoundRobinResult(RoundRobinStatus.SUCCESS, agentAssigned);


    }
}