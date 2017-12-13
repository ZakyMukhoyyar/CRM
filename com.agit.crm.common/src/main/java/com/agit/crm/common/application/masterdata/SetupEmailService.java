package com.agit.crm.common.application.masterdata;

import com.agit.crm.common.dto.masterdata.SetupEmailDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TriAA
 */
public interface SetupEmailService {

    void saveOrUpdate(SetupEmailDTO setupEmail);

    void delete(SetupEmailDTO setupEmail);

    SetupEmailDTO findByID(String idEmail);

    List<SetupEmailDTO> findAll();

    List<SetupEmailDTO> findByParams(Map map);

    SetupEmailDTO getDummy();

}
