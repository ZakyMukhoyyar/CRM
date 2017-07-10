package com.agit.crm.infrastructure.component.generic;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public class GenericClass <T> {
    
    private T paylod;
    
    private final Class<T> clazz;

    public GenericClass(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public T getPaylod() {
        return paylod;
    }
    
}
