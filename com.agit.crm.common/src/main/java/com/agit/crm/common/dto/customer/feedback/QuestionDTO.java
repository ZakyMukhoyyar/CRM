/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.common.dto.customer.feedback;

import com.agit.crm.shared.status.Status;
import com.agit.crm.shared.type.TypeTouchpoints;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BayuHS
 */
public class QuestionDTO implements Serializable {

    private String questionID;
    private TypeTouchpoints touchpoints;
    private Status status;
    private String question;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    
    
}
