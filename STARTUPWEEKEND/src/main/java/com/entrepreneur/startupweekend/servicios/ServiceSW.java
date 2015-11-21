package com.entrepreneur.startupweekend.servicios;

import com.entrepreneur.startupweekend.modelo.Posicion;
import com.entrepreneur.startupweekend.modelo.Usuario;
import com.entrepreneur.startupweekend.modelo.Zona;



public interface ServiceSW {
    
    Usuario persistUsuario(Usuario usuario)throws Exception;
    
    Posicion persistPosicion(Posicion posicion)throws Exception;
    
    Zona persistZona(Zona zona)throws Exception;

}
