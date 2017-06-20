/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main;

import java.text.MessageFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 *
 * @author leevydmalik
 */
public class MyFormatter extends Formatter {

    /**
     * @return 
     * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
     */
    @Override
    public String format(final LogRecord record) {
        return MessageFormat.format(record.getMessage(), record.getParameters());
    }
}