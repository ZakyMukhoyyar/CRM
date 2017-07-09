package com.agit.crm.domain.infrastructure.persistance.hibernate;

import com.agit.crm.domain.crm.Jurusan;
import com.agit.crm.domain.crm.JurusanRepository;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zaky
 */
public class JurusanHibernateRepository extends HibernateRepository implements JurusanRepository{

    @Override
    public void saveOrUpdate(Jurusan jurusan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteData(Jurusan jurusan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Jurusan findByID(String idJurusan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jurusan> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jurusan> findByParams(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
