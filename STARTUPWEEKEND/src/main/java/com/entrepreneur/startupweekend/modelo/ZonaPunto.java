package com.entrepreneur.startupweekend.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "zona_punto")
public class ZonaPunto implements Serializable {

    private static final long serialVersionUID = STARTUPWEEKEND.serialVersionIdShuffle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona_punto", nullable = false)
    private Long idZonaPunto;

    @Column(name = "latitud")
    private Double latitud;

    @Column(name = "longitud")
    private Double longitud;

    
    @ManyToOne()
    @JoinColumn(name = "id_zona", referencedColumnName = "id_zona", nullable = true, foreignKey = @ForeignKey(name = "none"))
    private Zona zona;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZonaPunto != null ? idZonaPunto.hashCode() : 0);
        return hash;
    }

     @Override
    public boolean equals(Object object) {
        if (!(object instanceof Posicion)) {
            return false;
        }
        ZonaPunto other = (ZonaPunto) object;
        if ((this.idZonaPunto == null && other.idZonaPunto != null) || (this.idZonaPunto != null && !this.idZonaPunto.equals(other.idZonaPunto))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "ZonaPunto[ idZonaPunto=" + idZonaPunto + " ]";
    }

    public Long getIdZonaPunto() {
        return idZonaPunto;
    }

    public void setIdZonaPunto(Long idZonaPunto) {
        this.idZonaPunto = idZonaPunto;
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

    /**
     * @return the zona
     */
    public Zona getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(Zona zona) {
        this.zona = zona;
    }

    
}
