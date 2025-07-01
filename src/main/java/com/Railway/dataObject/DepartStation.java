package com.Railway.dataObject;

public enum DepartStation {
    SAI_GON("Sài Gòn"),
    PHAN_THIET("Phan Thiết"),
    NHA_TRANG("Nha Trang"),
    DA_NANG("Đà Nẵng"),
    HUE("Huế"),
    QUANG_NGAI("Quảng Ngãi");

    private String station;
    DepartStation(String station){
        this.station=station;
    }
    public String getStation(){return  this.station;}

    public static DepartStation getStation(String station) {
        for (DepartStation s : DepartStation.values()) {
            if (s.station.equalsIgnoreCase(station)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid station name: " + station);
    }
}
