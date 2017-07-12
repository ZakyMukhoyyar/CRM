package com.agit.crm.acm.api.model;

/**
 *
 * @author lintang
 */
public interface ACMCallBack <T> {

    T executeInACMContext();
}
