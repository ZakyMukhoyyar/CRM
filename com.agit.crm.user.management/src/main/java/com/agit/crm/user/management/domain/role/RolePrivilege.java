package com.agit.crm.user.management.domain.role;

import com.agit.crm.shared.object.ValueObject;
import com.agit.crm.shared.type.AccessType;
import com.agit.crm.user.management.domain.privilege.Privilege;
import java.util.Objects;

/**
 * 
 *
 * @author bayutridewanto
 */
public class RolePrivilege implements ValueObject<RolePrivilege>{

    private Privilege privilege;
    private AccessType accessType;

    public RolePrivilege() {
    }

    public RolePrivilege(Privilege privilege, AccessType accessType) {
        this.privilege = privilege;
        this.accessType = accessType;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.privilege);
        hash = 23 * hash + Objects.hashCode(this.accessType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RolePrivilege other = (RolePrivilege) obj;
        if (!Objects.equals(this.privilege, other.privilege)) {
            return false;
        }
        if (this.accessType != other.accessType) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameValueAs(RolePrivilege other) {
        return this.equals(other);
    }
    
}
