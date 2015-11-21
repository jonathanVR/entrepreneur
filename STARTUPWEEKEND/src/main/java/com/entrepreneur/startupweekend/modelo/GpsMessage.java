package com.entrepreneur.startupweekend.modelo;

import java.io.Serializable;

public class GpsMessage implements Serializable {

    private String serial;
    private Long latitude;
    private Long longitude;

    public GpsMessage(String serial, Long latitude, Long longitude) {
        this.serial = serial;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
    
    

}
