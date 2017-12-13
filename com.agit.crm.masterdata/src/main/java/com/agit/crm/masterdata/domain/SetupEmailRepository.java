package com.agit.crm.masterdata.domain;

import java.util.List;
import java.util.Map;

/**
 *
 * @author TriAA
 */
public interface SetupEmailRepository {

    void saveOrUpdate(SetupEmail setupEmail);

    void delete(SetupEmail setupEmail);

    SetupEmail findByID(String idEmail);

    List<SetupEmail> findAll();

    List<SetupEmail> findByParams(Map map);
}
