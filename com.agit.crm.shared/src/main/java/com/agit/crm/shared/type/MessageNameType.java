package com.agit.crm.shared.type;

/**
 *
 * @author bayutridewanto
 */
public enum MessageNameType {
    APPROVED("APPROVED"),
    REJECTED("REJECTED"),
    CANCELED("CANCELED");
    
    private String messageName;

    private MessageNameType(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }
}
