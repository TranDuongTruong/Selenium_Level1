package com.Railway.data;

import com.Railway.model.Ticket;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.jar.asm.TypeReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketJsonReader {

    public static List<Ticket> getTicketsFromJson() {
        List<Ticket> tickets = new ArrayList<>();
        try {

            File file = new File("src/main/resources/data/ticket-dataset.json");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(file);
            for (JsonNode node : rootNode) {
                String departFrom = node.get("departFrom").asText();
                String arriveAt = node.get("arriveAt").asText();
                String departDate = node.get("departDate").asText();
                String seatType = node.get("seatType").asText();
                int amount = Integer.parseInt(node.get("amount").asText());
                //System.out.println(amount+"\t"+departFrom);
                Ticket ticket = new Ticket(departDate, departFrom, arriveAt, seatType, amount);
                tickets.add(ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public static Ticket getRandomTicket() {
        List<Ticket> tickets = getTicketsFromJson();
        return tickets.get(new Random().nextInt(tickets.size()));
    }
}
