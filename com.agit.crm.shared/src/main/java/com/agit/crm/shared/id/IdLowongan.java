package com.agit.crm.shared.id;

import com.agit.crm.shared.object.ValueObject;
import java.util.Objects;

/**
 *
 * @author BAYU HENDRA SETIAWAN
 */
public class IdLowongan implements ValueObject<IdLowongan> {

    private String id;

    public IdLowongan() {
    }

    public IdLowongan(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IdLowongan other = (IdLowongan) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameValueAs(IdLowongan other) {
        return this.equals(other);
    }

    @Override
    public String toString() {
        return "IdLowongan{" + "id=" + id + '}';
    }

}
