package com.Railway.model;


public class Ticket {
    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private int ticketAmount;

    public Ticket(String departDate, String departFrom, String arriveAt, String seatType, int ticketAmount) {

        this.departDate = departDate;
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }
    public Ticket(){}

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public void setArriveAt(String arriveAt) {
        this.arriveAt = arriveAt;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }




    public String getDepartDate() {
        return departDate;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public String getArriveAt() {
        return arriveAt;
    }

    public String getSeatType() {
        return seatType;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }


}

