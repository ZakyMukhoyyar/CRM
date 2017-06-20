package com.agit.crm.shared.zul;

import org.zkoss.zul.Div;
import org.zkoss.zul.Label;

/**
 *
 * @author bayutridewanto
 */
public class SignLabel extends Div {

    private Label label;
    private Label sign;
    private String lblValue;
    private String REQUIRED_SIGN = "* ";

    public SignLabel() {
        label = new Label();
        label.setSclass("form-label");
        appendChild(label);
        sign = new Label();
        sign.setValue(REQUIRED_SIGN);
        sign.setStyle("color: red");
        appendChild(sign);
    }

    public String getValue() {
        return lblValue;
    }

    public void setValue(String lblValue) {
        label.setValue(lblValue);
        this.lblValue = lblValue;
    }

}
