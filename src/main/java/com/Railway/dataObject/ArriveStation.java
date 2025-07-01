package com.Railway.dataObject;

public enum ArriveStation {
    SAI_GON("Sài Gòn"),
    PHAN_THIET("Phan Thiết"),
    NHA_TRANG("Nha Trang"),
    DA_NANG("Đà Nẵng"),
    HUE("Huế"),
    QUANG_NGAI("Quảng Ngãi");

    private String station;
    ArriveStation(String station){
        this.station=station;
    }
    public String getStation(){return  this.station;}

    public static ArriveStation getStation(String station) {
        for (ArriveStation s : ArriveStation.values()) {
            if (s.station.equalsIgnoreCase(station)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid station name: " + station);
    }
}
