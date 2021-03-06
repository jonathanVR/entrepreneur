package com.entrepreneur.startupweekend.dao;

import com.entrepreneur.startupweekend.dao.AbstractJpaDAO;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GenericJpaDao extends AbstractJpaDAO implements IGenericDao {


}
