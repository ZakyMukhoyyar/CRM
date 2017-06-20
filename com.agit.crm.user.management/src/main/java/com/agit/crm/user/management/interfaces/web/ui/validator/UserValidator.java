package com.agit.crm.user.management.interfaces.web.ui.validator;

import com.agit.crm.common.dto.usermanagement.AccessTimeDTO;
import com.agit.crm.shared.zul.GenericValidator;
import org.zkoss.bind.ValidationContext;

/**
 *
 * @author bayutridewanto
 */
public class UserValidator extends GenericValidator {

    @Override
    public void validate(ValidationContext ctx) {
        genericNullable(ctx, (String) ctx.getProperties("fullName")[0].getValue(), "fullName", EMPTY_MSG);
        genericNullable(ctx, (String) ctx.getValidatorArg("roleID"), "roleDTO", EMPTY_SELECTED_BOX_MSG);
        genericNullable(ctx, (String) ctx.getProperties("userName")[0].getValue(), "userName", EMPTY_MSG);
        genericNullable(ctx, (String) ctx.getProperties("email")[0].getValue(), "email", EMAIL_MSG);
        genericEmail(ctx, (String) ctx.getProperties("email")[0].getValue(), "email", EMAIL_MSG);
        genericNullable(ctx, (String) ctx.getProperties("mobilePhone")[0].getValue(), "mobilePhone", EMPTY_NUMBER_MSG);
        genericPhone(ctx, (String) ctx.getProperties("mobilePhone")[0].getValue(), "mobilePhone", NUMBER_MSG);

        AccessTimeDTO accessTimeDTO = (AccessTimeDTO) ctx.getValidatorArg("accessTime");
        if (accessTimeDTO.getSundayStart() == null || accessTimeDTO.getSundayEnd() == null
                || accessTimeDTO.getMondayStart() == null || accessTimeDTO.getMondayEnd() == null
                || accessTimeDTO.getTuesdayStart() == null || accessTimeDTO.getTuesdayEnd() == null
                || accessTimeDTO.getWednesdayStart() == null || accessTimeDTO.getWednesdayEnd() == null
                || accessTimeDTO.getThursdayStart() == null || accessTimeDTO.getThursdayEnd() == null
                || accessTimeDTO.getFridayStart() == null || accessTimeDTO.getFridayEnd() == null
                || accessTimeDTO.getSaturdayStart() == null || accessTimeDTO.getSaturdayEnd() == null) {
            this.addInvalidMessage(ctx, "accessTime", "Access time may not be empty");
        }
    }
}
