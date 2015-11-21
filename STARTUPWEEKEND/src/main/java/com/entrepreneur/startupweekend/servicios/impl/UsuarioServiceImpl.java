package com.entrepreneur.startupweekend.servicios.impl;

import com.entrepreneur.startupweekend.dao.AbstractJpaDAO;
import com.entrepreneur.startupweekend.dao.IGenericDao;
import com.entrepreneur.startupweekend.modelo.Usuario;
import com.entrepreneur.startupweekend.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends AbstractJpaDAO<Usuario> implements UsuarioService {

    IGenericDao<Usuario> dao;

    @Autowired
    public void setDao(IGenericDao<Usuario> daoToSet) {
        dao = daoToSet;
        dao.setClazz(Usuario.class);
    }

    @Override
    public Usuario persistUsuario(Usuario admUsuario) throws Exception {
        try {
            admUsuario.setIdUsuario(null);            
            dao.create(admUsuario);
            return admUsuario;

        } catch (Exception e) {
            throw e;
        }
    }

}
