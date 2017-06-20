package com.agit.crm.shared.object;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ence.prastama
 */
public class CreationalSpecification implements ValueObject<CreationalSpecification> {

    private Date createdAt;
    private String createdBy;
    private Date modifiedAt;
    private String modifiedBy;

    public CreationalSpecification() {
    }

    public CreationalSpecification(Date createdAt, String createdBy, Date modifiedAt, String modifiedBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.createdAt);
        hash = 23 * hash + Objects.hashCode(this.createdBy);
        hash = 23 * hash + Objects.hashCode(this.modifiedAt);
        hash = 23 * hash + Objects.hashCode(this.modifiedBy);
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
        final CreationalSpecification other = (CreationalSpecification) obj;
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        if (!Objects.equals(this.createdBy, other.createdBy)) {
            return false;
        }
        if (!Objects.equals(this.modifiedAt, other.modifiedAt)) {
            return false;
        }
        if (!Objects.equals(this.modifiedBy, other.modifiedBy)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameValueAs(CreationalSpecification other) {
        return this.equals(other);
    }

    @Override
    public String toString() {
        return "CreationalSpecification{" + "createdAt=" + createdAt + ", createdBy=" + createdBy + ", modifiedAt=" + modifiedAt + ", modifiedBy=" + modifiedBy + '}';
    }

    public static CreationalSpecification getInstance() {
        CreationalSpecification cs = new CreationalSpecificationBuilder()
                .setCreatedAt(new Date())
                .setCreatedBy("USER")
                .setModifiedAt(new Date())
                .setModifiedBy("USER")
                .createCreationalSpecification();

        return cs;
    }
}
