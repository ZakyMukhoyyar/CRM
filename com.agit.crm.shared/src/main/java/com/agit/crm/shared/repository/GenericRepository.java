package com.agit.crm.shared.repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author bayutridewanto
 * @param <T>
 * @param <K>
 */
public interface GenericRepository <T, K extends Serializable>{
    
    /**
     * might not hit db, return proxy placeholder, throw ex if no rec found
     * @param key
     * @return 
     */
    public T load(K key);
        
    /**
     * always hit db, might return null if no rec found
     * @param key
     * @return 
     */
    public T findOne(K key);
    public List<T> findAll();
    public boolean deleteById(K key);   
    public void flush();    
    public void clear();

}
