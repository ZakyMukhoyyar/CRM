package com.agit.crm.shared.id;

import com.agit.crm.shared.object.ValueObject;
import java.util.Objects;

/**
 *
 * @author BAYU HENDRA SETIAWAN
 */
public class IdMahasiswa implements ValueObject<IdMahasiswa> {

    private String id;

    public IdMahasiswa() {
    }

    public IdMahasiswa(String id) {
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
        int hash = 7;
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
        final IdMahasiswa other = (IdMahasiswa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IdMahasiswa{" + "id=" + id + '}';
    }

    @Override
    public boolean sameValueAs(IdMahasiswa other) {
        return this.equals(other);
    }

}
