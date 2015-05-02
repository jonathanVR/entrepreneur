package com.entrepreneur.shuffle.servicios.impl.adm;

import com.entrepreneur.shuffle.dao.AbstractJpaDAO;
import com.entrepreneur.shuffle.dao.IGenericDao;
import com.entrepreneur.shuffle.modelo.adm.AdmUsuario;
import com.entrepreneur.shuffle.servicios.adm.AdmUsuarioService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmUsuarioServiceImpl extends AbstractJpaDAO<AdmUsuario> implements AdmUsuarioService {

    IGenericDao<AdmUsuario> dao;

    
    @Autowired
    public void setDao(IGenericDao<AdmUsuario> daoToSet) {
        dao = daoToSet;
        dao.setClazz(AdmUsuario.class);
    }

    

    @Override
    public AdmUsuario persistAdmUsuario(AdmUsuario admUsuario) throws Exception {
        admUsuario.setIdUsuario(null);
        admUsuario.setUsuarioAlta("SYS");
        admUsuario.setFechaAlta(new Date());
        dao.create(admUsuario);
        return admUsuario;
    }

}
