package com.entrepreneur.startupweekend.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zona")
public class Zona implements Serializable {

    private static final long serialVersionUID = STARTUPWEEKEND.serialVersionIdShuffle;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona", nullable = false)
    private Long idZona;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "zona")
    //@JoinColumn(name = "puntos", referencedColumnName = "idZonaPunto", nullable = true, foreignKey = @ForeignKey(name = "none"))
    private List<ZonaPunto> puntos;
    
    
    @Override
    public String toString() {
        return "Zona[ idZona=" + idZona + " ]";
    }   

    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the puntos
     */
    public List<ZonaPunto> getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(List<ZonaPunto> puntos) {
        this.puntos = puntos;
    }
}
