package com.agit.crm.shared.audit;

import java.util.Date;

/**
 *
 * @author bayutridewanto
 */
public interface JDCAudit {

    String getCreateBy();

    void setCreateBy(String createBy);

    Date getCreateDate();

    void setCreateDate(Date createDate);

    String getUpdateBy();

    void setUpdateBy(String updateBy);

    Date getUpdateDate();

    void setUpdateDate(Date updateDate);

    void setIdService(String idService);

    String getIdService();

}