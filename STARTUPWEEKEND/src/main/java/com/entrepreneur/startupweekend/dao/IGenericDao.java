package com.entrepreneur.startupweekend.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao{
    
   // public void setClazz(final Class<T> clazzToSet);

    Serializable findOne(Class clazz, final Long id);

    Serializable findOne(Class clazz,final String id);

   List findAll(Class clazz);
 
   void create(final Serializable entity);
 
   Serializable update(final Serializable entity);
 
   void delete(final Serializable entity);
 
   void deleteById(Class clazz,final long entityId);
   
  
    
}
