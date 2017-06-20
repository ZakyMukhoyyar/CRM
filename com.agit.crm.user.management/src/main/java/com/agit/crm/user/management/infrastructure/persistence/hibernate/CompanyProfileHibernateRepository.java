package com.agit.crm.user.management.infrastructure.persistence.hibernate;

//package com.agit.crm.user.management.infrastructure.persistence.hibernate;
//
//import com.agit.crm.user.management.domain.company.profile.CompanyProfile;
//import com.agit.crm.user.management.domain.company.profile.CompanyProfileRepository;
//import com.bitozen.skk.util.StringUtil;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import org.hibernate.Criteria;
//import org.hibernate.Query;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author RBS
// */
//@Repository
//@Transactional
//public class CompanyProfileHibernateRepository extends HibernateRepository implements CompanyProfileRepository {
//
//    @Override
//    public void saveOrUpdate(CompanyProfile companyProfile) {
//        getSession().saveOrUpdate(companyProfile);
//    }
//
//    @Override
//    public CompanyProfile findByID(String fullname) {
//        Criteria criteria = getSession().createCriteria(CompanyProfile.class)
//                .add(Restrictions.in("fullname", Arrays.asList(fullname.toLowerCase(), fullname.toUpperCase())));
//        return (CompanyProfile) criteria.uniqueResult();
//    }
//
//    @Override
//    public List<CompanyProfile> findAll() {
//        Criteria criteria = getSession().createCriteria(CompanyProfile.class);
//        return (List<CompanyProfile>) criteria.list();
//    }
//
//    @Override
//    public List<CompanyProfile> findByParams(Map map) {
//        Criteria criteria = getSession().createCriteria(CompanyProfile.class);
//
//        if (StringUtil.hasValue(map.get("fullname"))) {
//            criteria.add(Restrictions.like("fullname", "%" + map.get("fullname") + "%").ignoreCase());
//        }
//        return criteria.list();
//    }
//
//    @Override
//    public void deleteData(CompanyProfile companyProfile) {
//        Query query = getSession().createQuery("delete from com.bitozen.skk.user.management.domain.company.profile.CompanyProfile where fullname = :name");
//        query.setParameter("name", companyProfile.getFullname());
//        query.executeUpdate();
//    }
//
//}
