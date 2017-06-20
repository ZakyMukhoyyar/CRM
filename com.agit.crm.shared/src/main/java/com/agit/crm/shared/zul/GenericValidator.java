package com.agit.crm.shared.zul;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

/**
 *
 * @author bayutridewanto
 */
public class GenericValidator extends AbstractValidator {

    public final String MAX_AMOUNT = "99999999999999999999.99";
    public final String MAX_FEE_IN_PERCENT = "99.9999";
    public final String MAX_FEE_IN_DECIMAL = "0.999999";
    public final String MAX_PRICE_IN_PERCENT = "999.999";
    public final String MAX_PRICE_IN_DECIMAL = "9.999999";
    public final String MAX_VALUE = "999999";
    public final String MAX_PERCENT = "999.00";
    public final String MAX_DAYS = "999";
    
    public String EMPTY_MSG = "This field may not be empty or contain only spaces.";
    public String NUMBER_MSG = "This field must contain only numbers.";
    public String EMPTY_NUMBER_MSG = "Phone number may not be empty.";
    public String EMAIL_MSG = "Please insert a valid e-mail address.";
    public String EMPTY_RADIO_MSG = "Please select the option.";
    public String EMPTY_SELECTED_BOX_MSG = "This field must be selected.";
    public String EMPTY_DATEBOX_MSG = "Please select the date.";
    public String EMPTY_TIMEBOX_MSG = "Please select the time.";
    public String SELECTED_MSG_VALUE = "Please select the ";
    public String VALID_MSG_VALUE = "Please insert a valid ";
    public String EXCEED_MAX = "Exceed the maximum value";
    public String EMPTY_LIST = "This list may not be empty";
    
    @Override
    public void validate(ValidationContext vc) {
    }

    public void genericNullable(ValidationContext ctx, String property, String key, String nameMessage) {
        if (property == null || property.trim().equals("")) {
            this.addInvalidMessage(ctx, key, nameMessage);
        }
    }

    public void genericNullableObject(ValidationContext ctx, Object property, String key, String nameMessage) {
        if (property == null) {
            this.addInvalidMessage(ctx, key, nameMessage);
        }
    }

    //Handling size
    public void genericSizeable(ValidationContext ctx, String property, String key, String message, int maxSize) {
        if (property.length() <= maxSize) {
            this.addInvalidMessage(ctx, key, message);
        }
    }

    public void genericEmail(ValidationContext ctx, String property, String key, String message) {
        if ((property != null) && (!property.matches("^[A-Za-z0-9+_.-]+@[a-zA-Z0-9.]+$")) && (!property.equals(""))) {
            this.addInvalidMessage(ctx, key, message);
        }
    }

    public void genericPhone(ValidationContext ctx, String property, String key, String message) {
        if ((property != null) && (!property.equals("")) && (!property.matches("[+0-9]+$"))) {
            this.addInvalidMessage(ctx, key, message);
        }
    }

    public void genericListSize(ValidationContext ctx, List<Object> property, String key, String message) {
        if (property.isEmpty()) {
            this.addInvalidMessage(ctx, key, message);
        }
    }

    public void check(ValidationContext ctx, Property[] p, String key, String type) {
        type = type.toLowerCase();
        type = type.trim();
        switch (type) {
            case "combobox":
                if (p != null) {
                    genericNullable(ctx, (String) p[0].getValue(), key, EMPTY_SELECTED_BOX_MSG);
                }
                break;
            case "datebox":
                if (p != null) {
                    genericNullable(ctx, p[0].getValue().toString(), key, EMPTY_DATEBOX_MSG);
                }
                break;
            case "emailbox":
                if (p != null) {
                    genericNullable(ctx, (String) p[0].getValue(), key, EMPTY_MSG);
                    genericEmail(ctx, (String) p[0].getValue(), key, EMAIL_MSG);
                }
                break;
            case "numberbox":
                if (p != null) {
                    genericNullable(ctx, String.valueOf(p[0].getValue()), key, EMPTY_NUMBER_MSG);
                    genericPhone(ctx, String.valueOf(p[0].getValue()), key, NUMBER_MSG);
                }
                break;
            case "radio":
                if (p != null) {
                    genericNullable(ctx, String.valueOf(p[0].getValue()), key, EMPTY_RADIO_MSG);
                }
                break;
            case "textbox":
                if (p != null) {
                    genericNullable(ctx, (String) p[0].getValue(), key, EMPTY_MSG);
                }
                break;
        }

    }

    public void genericValueSize(ValidationContext ctx, int maxValue, int minValue, String key, String message) {
        if (maxValue < minValue) {
            this.addInvalidMessage(ctx, key, message);
        }
    }
    public void genericMinimumValue(ValidationContext ctx, double minValue, double property, String key, String message) {
        if (minValue == property) {
            this.addInvalidMessage(ctx, key, message);
        }
    }
    public void genericNegativeValue(ValidationContext ctx, BigDecimal property, String key, String message) {
        if (property == null || property.compareTo(BigDecimal.ZERO) < -1) {
            this.addInvalidMessage(ctx, key, message);
        }
    }

    public void genericNumeric(ValidationContext ctx, String property, String key, String message) {
        if (property != null && !property.matches("[0-9]+$")) {
            this.addInvalidMessage(ctx, key, message);
        }
    }

    public void genericSelectable(ValidationContext ctx, String property, String key, String nameMessage) {
        if (property == null || property.trim().equals(CommonViewModel.PLEASE_SELECT)) {
            this.addInvalidMessage(ctx, key, nameMessage);
        }
    }

    public void genericMaxValue(ValidationContext ctx, Integer minValue, Integer maxValue, String key, String message) {
        if (minValue >= maxValue) {
            this.addInvalidMessage(ctx, key, message);
        }
    }

    public void genericCompareDate(ValidationContext ctx, Date startDate, Date endDate, String key, String nameMessage) {
        if (startDate.after(endDate)) {
            this.addInvalidMessage(ctx, key, nameMessage);
        }
    }
}
