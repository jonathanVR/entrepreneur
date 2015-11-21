package com.entrepreneur.startupweekend.servicios;

import com.entrepreneur.startupweekend.modelo.Usuario;



public interface UsuarioService {
    
    Usuario persistUsuario(Usuario admUsuario)throws Exception;

    
}
