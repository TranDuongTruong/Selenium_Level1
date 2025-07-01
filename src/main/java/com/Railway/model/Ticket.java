package com.Railway.model;


import com.Railway.dataObject.ArriveStation;
import com.Railway.dataObject.DepartStation;
import com.Railway.dataObject.SeatType;

public class Ticket {
    private String departDate;
    private DepartStation departFrom;
    private ArriveStation arriveAt;
    private SeatType seatType;
    private int ticketAmount;

    public Ticket(String departDate, DepartStation departFrom, ArriveStation arriveAt, SeatType seatType, int ticketAmount) {
        this.departDate = departDate;
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }
    public Ticket(){}

    public String getDepartDate() {
        return departDate;
    }

    public DepartStation getDepartFrom() {
        return departFrom;
    }

    public ArriveStation getArriveAt() {
        return arriveAt;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public void setDepartFrom(DepartStation departFrom) {
        this.departFrom = departFrom;
    }

    public void setArriveAt(ArriveStation arriveAt) {
        this.arriveAt = arriveAt;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public  String getTicketInfo(){
        return "Depart Date: "+this.getDepartDate() +"\t Depart station: "+this.getDepartFrom().getStation()+"\tArrive station: "+this.getArriveAt().getStation()+"\tSeat type: "+this.getSeatType().getSeatType()+"\tAmount: "+this.getTicketAmount();
    }

}

