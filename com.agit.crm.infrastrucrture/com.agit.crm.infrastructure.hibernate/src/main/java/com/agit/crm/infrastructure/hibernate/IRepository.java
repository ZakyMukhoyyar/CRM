package com.agit.crm.infrastructure.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public abstract interface IRepository<T> {

    T get(Serializable paramSerializable);

    List<T> findAll();

    Serializable save(T paramT);
    
    void store(T paramT);

    void update(T paramT);

    void delete(T paramT);

    List findByNamedQuery(String paramString);
    
    T findLatestObject();
    
    Object findUsingNative(String string);
}
