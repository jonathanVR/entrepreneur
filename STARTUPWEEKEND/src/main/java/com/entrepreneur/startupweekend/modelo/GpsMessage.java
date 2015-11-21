package com.entrepreneur.startupweekend.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class GpsMessage implements Serializable {

    private String serial;
    private Double latitude;
    private Double longitude;

    public GpsMessage() {
        
    }
    
    public GpsMessage(String serial, Double latitude, Double longitude) {
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    
}
