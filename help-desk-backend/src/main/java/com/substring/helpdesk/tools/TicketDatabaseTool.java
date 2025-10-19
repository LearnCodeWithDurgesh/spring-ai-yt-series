package com.substring.helpdesk.tools;

import com.substring.helpdesk.entity.Ticket;
import com.substring.helpdesk.service.TicketService;
import jakarta.servlet.Servlet;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;

    // create ticket tool
    @Tool(description = "This tool helps to create new ticket in database.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket fields required to create new ticket") Ticket ticket) {
        try {
            System.out.println("going to create ticket");
            System.out.println(ticket);
            return ticketService.createTicket(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    // get ticket using username
    @Tool(description = "This tool helps to get ticket by username.")
    public Ticket getTicketByUserName(@ToolParam(description = " email id whose ticket is required ") String emailid) {
        return ticketService.getTicketByEmailId(emailid);
    }

    @Tool(description = "This tool helps to update ticket.")
    public Ticket updateTicket(@ToolParam(description = "new ticket fields required to update with ticket id.") Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    // get current system time
    @Tool(description = "This tool helps to get current system time.")
    public String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }


}
