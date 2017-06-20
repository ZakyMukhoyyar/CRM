package com.agit.crm.user.management.interfaces.web.ui.validator;

import com.agit.crm.shared.zul.GenericValidator;
import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;

/**
 *
 * @author bayutridewanto
 */
public class GroupValidator extends GenericValidator {

    @Override
    public void validate(ValidationContext ctx) {

        Property[] roleID = ctx.getProperties("roleID");
        if (roleID != null) {
            genericNullable(ctx, (String) roleID[0].getValue(), "roleID", EMPTY_MSG);
        }

        genericNullable(ctx, (String) ctx.getProperties("roleName")[0].getValue(), "roleName", EMPTY_MSG);

        genericNullable(ctx, (String) ctx.getProperties("roleDescription")[0].getValue(), "roleDescription", EMPTY_MSG);
    }
}
