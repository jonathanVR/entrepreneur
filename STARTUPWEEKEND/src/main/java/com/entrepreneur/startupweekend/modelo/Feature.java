/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entrepreneur.startupweekend.modelo;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author gus
 */
public class Feature implements Serializable {
    
    private final String type="Feature";
    private Map properties;
    private Map geometry;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the properties
     */
    public Map getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(Map properties) {
        this.properties = properties;
    }

    /**
     * @return the geometry
     */
    public Map getGeometry() {
        return geometry;
    }

    /**
     * @param geometry the geometry to set
     */
    public void setGeometry(Map geometry) {
        this.geometry = geometry;
    }
    
}
