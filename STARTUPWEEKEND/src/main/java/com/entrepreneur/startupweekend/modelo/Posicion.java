package com.entrepreneur.startupweekend.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posicion")
public class Posicion implements Serializable {

    private static final long serialVersionUID = STARTUPWEEKEND.serialVersionIdShuffle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_posicion", nullable = false)
    private Long idPosicion;

    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "longitud")
    private Double longitud;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPosicion != null ? idPosicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Posicion)) {
            return false;
        }
        Posicion other = (Posicion) object;
        if ((this.idPosicion == null && other.idPosicion != null) || (this.idPosicion != null && !this.idPosicion.equals(other.idPosicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Posicion[ idPosicion=" + idPosicion + " ]";
    }

    public Long getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(Long idPosicion) {
        this.idPosicion = idPosicion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    
}
