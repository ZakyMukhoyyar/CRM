package com.agit.crm.shared.audit;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

/**
 *
 * @author bayutridewanto
 */
@MappedSuperclass
@Audited
public class JDCAuditVersioning extends JDCAuditImpl implements Serializable {

    @Version
    @Column(name = "VERSION", nullable = false)
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}