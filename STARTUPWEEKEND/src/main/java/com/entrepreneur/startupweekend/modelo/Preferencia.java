package com.entrepreneur.startupweekend.modelo;



import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preferencia")
public class Preferencia implements Serializable {

    private static final long serialVersionUID = STARTUPWEEKEND.serialVersionIdShuffle;    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preferencia", nullable = false)
    private Long idPreferencia;
        
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    @Column(name = "id_cliente")
    private Long idCliente;
    
    @Column(name = "vegetariana")
    private Boolean vegetariana;        
                     
    @Column(name = "cremas")
    private Boolean cremas;        
                     
    @Column(name = "ensalada")
    private Boolean ensalada;                                 
    
    @Column(name = "rapida")
    private Boolean rapida;
    
    @Column(name = "pollo")
    private Boolean pollo;
    
    @Column(name = "hamburguesa")
    private Boolean hamburguesa;                
    
    @Column(name = "pizza")
    private Boolean pizza; 
    
    @Column(name = "jamon")
    private Boolean jamon;
    
    @Column(name = "hawaiana")
    private Boolean hawaiana;        
                
    @Column(name = "cafe")
    private Boolean cafe;        
                    
    @Column(name = "americano")
    private Boolean americano;        
                    
    @Column(name = "capuchino")
    private Boolean capuchino;                 
    
    @Column(name = "jugos_naturales")
    private Boolean jugosNaturales;   
    
    @Column(name = "naranja")
    private Boolean naranja;   
    
    @Column(name = "sandia")
    private Boolean sandia;       
                     
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreferencia != null ? idPreferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Preferencia)) {
            return false;
        }
        Preferencia other = (Preferencia) object;
        if ((this.idPreferencia == null && other.idPreferencia != null) || (this.idPreferencia != null && !this.idPreferencia.equals(other.idPreferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Preferencia[ idPreferencia=" + idPreferencia + " ]";
    }      

    public Long getIdPreferencia() {
        return idPreferencia;
    }

    public void setIdPreferencia(Long idPreferencia) {
        this.idPreferencia = idPreferencia;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Boolean getVegetariana() {
        return vegetariana;
    }

    public void setVegetariana(Boolean vegetariana) {
        this.vegetariana = vegetariana;
    }

    public Boolean getCremas() {
        return cremas;
    }

    public void setCremas(Boolean cremas) {
        this.cremas = cremas;
    }

    public Boolean getEnsalada() {
        return ensalada;
    }

    public void setEnsalada(Boolean ensalada) {
        this.ensalada = ensalada;
    }

    public Boolean getRapida() {
        return rapida;
    }

    public void setRapida(Boolean rapida) {
        this.rapida = rapida;
    }

    public Boolean getPollo() {
        return pollo;
    }

    public void setPollo(Boolean pollo) {
        this.pollo = pollo;
    }

    public Boolean getHamburguesa() {
        return hamburguesa;
    }

    public void setHamburguesa(Boolean hamburguesa) {
        this.hamburguesa = hamburguesa;
    }

    public Boolean getPizza() {
        return pizza;
    }

    public void setPizza(Boolean pizza) {
        this.pizza = pizza;
    }

    public Boolean getJamon() {
        return jamon;
    }

    public void setJamon(Boolean jamon) {
        this.jamon = jamon;
    }

    public Boolean getHawaiana() {
        return hawaiana;
    }

    public void setHawaiana(Boolean hawaiana) {
        this.hawaiana = hawaiana;
    }

    public Boolean getCafe() {
        return cafe;
    }

    public void setCafe(Boolean cafe) {
        this.cafe = cafe;
    }

    public Boolean getAmericano() {
        return americano;
    }

    public void setAmericano(Boolean americano) {
        this.americano = americano;
    }

    public Boolean getCapuchino() {
        return capuchino;
    }

    public void setCapuchino(Boolean capuchino) {
        this.capuchino = capuchino;
    }

    public Boolean getJugosNaturales() {
        return jugosNaturales;
    }

    public void setJugosNaturales(Boolean jugosNaturales) {
        this.jugosNaturales = jugosNaturales;
    }

    public Boolean getNaranja() {
        return naranja;
    }

    public void setNaranja(Boolean naranja) {
        this.naranja = naranja;
    }

    public Boolean getSandia() {
        return sandia;
    }

    public void setSandia(Boolean sandia) {
        this.sandia = sandia;
    }
    
    
}
