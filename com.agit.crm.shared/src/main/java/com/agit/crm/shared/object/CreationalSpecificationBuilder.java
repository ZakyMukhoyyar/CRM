package com.agit.crm.shared.object;

import java.util.Date;


public class CreationalSpecificationBuilder {
    private Date createdAt;
    private String createdBy;
    private Date modifiedAt;
    private String modifiedBy;

    public CreationalSpecificationBuilder() {
    }

    public CreationalSpecificationBuilder setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public CreationalSpecificationBuilder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public CreationalSpecificationBuilder setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public CreationalSpecificationBuilder setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public CreationalSpecification createCreationalSpecification() {
        return new CreationalSpecification(createdAt, createdBy, modifiedAt, modifiedBy);
    }

}
