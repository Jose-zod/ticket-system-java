package com.jmartin.support;
import com.jmartin.support.service.TicketService;
import com.jmartin.support.model.User;

public class Main {
    public static void main(String[] args) {

        TicketService service= new TicketService();
        User user = new User (1,"juan perez", "juan@email.com") ;
        User user1 = new User (2,"ricardo","ricardo@rmail.com");

        int ticketid = service.createTicket(
                "no enciende la laptop",
                "la laptop no responde al boton de encendido",
                user
        );

    }
}