package com.entrepreneur.startupweekend.servicios.impl;

import com.entrepreneur.startupweekend.dao.IGenericDao;
import com.entrepreneur.startupweekend.modelo.Posicion;
import com.entrepreneur.startupweekend.modelo.Usuario;
import com.entrepreneur.startupweekend.modelo.Zona;
import com.entrepreneur.startupweekend.modelo.ZonaPunto;
import com.entrepreneur.startupweekend.servicios.ServiceSW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSWImpl implements ServiceSW {

    @Autowired
    IGenericDao dao;
    
    @Override
    public Usuario persistUsuario(Usuario usuario) throws Exception {
        try {
            usuario.setIdUsuario(null);            
            dao.create(usuario);
            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public Posicion persistPosicion(Posicion posicion) throws Exception {
        try {
            posicion.setIdPosicion(null);            
            dao.create(posicion);
            return posicion;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Zona persistZona(Zona zona) throws Exception {
        try {
            zona.setIdZona(null);            
            dao.create(zona);
            return zona;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ZonaPunto persistZonaPunto(ZonaPunto zonaPunto) throws Exception {
        try {
            zonaPunto.setIdZonaPunto(null);
            dao.create(zonaPunto);
            return zonaPunto;
        } catch (Exception e) {
            throw e;
        }
    }
    
    

}
