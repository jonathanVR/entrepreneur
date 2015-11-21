package com.entrepreneur.startupweekend.servicios;

import com.entrepreneur.startupweekend.modelo.Posicion;
import com.entrepreneur.startupweekend.modelo.Usuario;



public interface ServiceSW {
    
    Usuario persistUsuario(Usuario usuario)throws Exception;
    
    Posicion persistPosicion(Posicion posicion)throws Exception;

}
