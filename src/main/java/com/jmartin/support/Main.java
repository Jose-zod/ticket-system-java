package com.jmartin.support;
import com.jmartin.support.model.UserType;
import com.jmartin.support.service.RoundRobinResult;
import com.jmartin.support.service.TicketService;
import com.jmartin.support.model.User;
import java.util.List;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        User user = new User(1, "juan perez", "juan@email.com", UserType.CUSTOMER);


        List<User> agents = List.of(
                new User(2, "ricardo", "ricardo@rmail.com", UserType.AGENT),
                new User(3, "adam", "adam@adam.com", UserType.AGENT)
        );
        TicketService service = new TicketService(agents);


        String menuOptionstr;

        int menuOptionint = 0;
        boolean isValid;
        boolean running = true;

        JOptionPane.showMessageDialog(null, "Welcome to the Ticket System");

        do {
            JOptionPane.showMessageDialog(null,
                    "please enter your request ");
            do {
                isValid = true;
                try {
                    menuOptionstr = JOptionPane.showInputDialog(null, "1. Create a ticket. \n2 Assign  ticket. \n3 Exit  ");
                    if (menuOptionstr == null) {
                        JOptionPane.showMessageDialog(null, "Exiting  the application, see you later ");
                        System.exit(0);
                    }

                    if (menuOptionstr.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Option can not be empty");
                        isValid = false;
                        continue;
                    }
                    menuOptionint = Integer.parseInt(menuOptionstr.trim());

                    if (menuOptionint > 3 || menuOptionint < 1) {
                        JOptionPane.showMessageDialog(null, "Option have to be a number between 1 and 3");
                        isValid = false;
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Option have to be a number between 1 and 3");
                    isValid = false;
                }

            } while (!isValid);

            switch (menuOptionint) {

                case 1:
                    // ticket title
                    int ticketid;
                    String title;
                    String description;
                    do {
                        isValid = true;
                        title = JOptionPane.showInputDialog(null, "Ticket title ");
                        if (title == null) {
                            JOptionPane.showMessageDialog(null, "Exiting  the application, see you later  ");
                            System.exit(0);
                        }
                        if (title.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Option can not be empty");
                            isValid = false;
                        }
                    } while (!isValid);

                    // ticket description
                    do {
                        isValid = true;

                        description = JOptionPane.showInputDialog(null, "Ticket description ");
                        if (description == null) {
                            JOptionPane.showMessageDialog(null, "Exiting  the application, see you later  ");
                            System.exit(0);
                        }
                        if (description.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Option can not be empty");
                            isValid = false;
                        }
                    } while (!isValid);

                    ticketid = service.createTicket(
                            title,
                            description,
                            user
                    );
                    JOptionPane.showMessageDialog(null,
                            "Ticket created successfully ID: "
                                    + ticketid +
                                    " please hold on.... an agent will be assigned to your ticket");
                    break;

                case 2:
                  int   ticket_nbr = 0;
                    do {
                        isValid = true;
                        try {

                            String ticket_id = JOptionPane.showInputDialog(null, "please enter ticket id");
                            if (ticket_id == null) {
                                JOptionPane.showMessageDialog(null, "Exiting  the application, see you later ");
                                System.exit(0);
                            }

                            if (ticket_id.trim().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Ticket id cannot be empty");
                                isValid = false;
                                continue;
                            }

                                    ticket_nbr = Integer.parseInt(ticket_id.trim());
                            if (ticket_nbr<=0){
                                JOptionPane.showMessageDialog(null, "Ticket id must be greater than 0");
                                isValid = false;
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ticket id must be a number ");
                            isValid = false;
                        }

                    } while (!isValid);


                      RoundRobinResult result = service.roundRobin(ticket_nbr);
                        switch (result.getStatus()) {

                            case TICKET_NOT_FOUND: JOptionPane.showMessageDialog(null,"ticket not found, returning to main menu  ");
                                break;
                            case NO_AGENTS: JOptionPane.showMessageDialog(null," no agents available");
                                break;
                            case INVALID_AGENT: JOptionPane.showMessageDialog(null,"ticket can only be assigned to an agent ");
                                break;
                            case SUCCESS:
                                User agent = result.getAgentAssigned();
                                JOptionPane.showMessageDialog(null,"ticket assigned successfully  to " + agent.getName());
                                break;
                        }

                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Exiting  the application, see you later ");
                    running = false;
                    break;


            }

        } while (running) ;
    }
}