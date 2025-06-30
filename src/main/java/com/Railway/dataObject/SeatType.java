package com.Railway.dataObject;

public enum SeatType {
    HARD_SEAT("Hard seat"),
    SOFT_SEAT("Soft seat"),
    SOFT_SEAT_WITH_AIR_CONDITIONER("Soft seat with air conditioner"),
    HARD_BED("Hard bed"),
    SOFT_BED("Soft bed"),
    SOFT_BED_WITH_AIR_CONDITIONER("Soft bed with air conditioner");
    private String type;
    SeatType(String type){
        this.type=type;
    }
    public String getSeatType(){return this.type;}


    public static SeatType getSeatType(String type) {
        for (SeatType s : SeatType.values()) {
            if (s.type.equalsIgnoreCase(type)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid station name: " + type);
    }
}
