package com.entrepreneur.startupweekend.modelo;

import java.io.Serializable;
import java.util.List;

public class ZonaPojo implements Serializable {
    
    private String nombreZona;
    private List<ZonaPunto> coordinates;

    /**
     * @return the nombreZona
     */
    public String getNombreZona() {
        return nombreZona;
    }

    /**
     * @param nombreZona the nombreZona to set
     */
    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    /**
     * @return the coordinates
     */
    public List<ZonaPunto> getCoordinates() {
        return coordinates;
    }

    /**
     * @param coordinates the coordinates to set
     */
    public void setCoordinates(List<ZonaPunto> coordinates) {
        this.coordinates = coordinates;
    }
    
    
}
