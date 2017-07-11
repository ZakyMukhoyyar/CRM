package com.agit.crm.infrastructure.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bayutridewanto
 */
@Repository
@Transactional
public abstract class AbstractHibernate4Dao<T> {
    private SessionFactory A;
    
    @SuppressWarnings("unchecked")
    protected final Class<T> entityClass = (Class<T>)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Required
    public void setSessionFactory(SessionFactory paramSessionFactory) {
        this.A = paramSessionFactory;
    }

    protected Session getSession() {
        return this.A.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
    public T get(Serializable paramSerializable) {
        return (T) getSession().get(this.entityClass, paramSerializable);
    }

    public Serializable save(T paramT) {
        return getSession().save(paramT);
    }
    
    public void store(T paramT) {
        getSession().saveOrUpdate(paramT);
    }

    public void update(T paramT) {
        getSession().update(paramT);
    }

    public void delete(T paramT) {
        getSession().delete(paramT);
    }

    @SuppressWarnings("unchecked")
	public List<T> findAll() {
        return getSession().createCriteria(this.entityClass).list();
    }
    
    @SuppressWarnings("rawtypes")
	public List findByNamedQuery(String paramString) {
        return getSession().getNamedQuery(paramString).list();
    }
    
    public Object findUsingNative(String string) {
        return getSession().createSQLQuery(string);
    }
    
    @SuppressWarnings("unchecked")
	public T findLatestObject() {
        Criteria criteria = getSession().createCriteria(this.entityClass)
                .addOrder(Order.desc("id"))
                .setMaxResults(1);
        return (T) criteria.uniqueResult();
    }
}
