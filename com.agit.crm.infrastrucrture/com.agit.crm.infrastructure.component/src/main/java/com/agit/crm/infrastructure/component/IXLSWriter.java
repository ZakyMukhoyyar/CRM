package com.agit.crm.infrastructure.component;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public interface IXLSWriter<T> {

    void writeThisObjectToFile(List<T> data, String fileName, String sheetName)  throws IOException,IntrospectionException,IllegalAccessException,IllegalArgumentException,InvocationTargetException;
    
    byte[] writeThisObjectToStream(List<T> data, String sheetName)  throws IOException,IntrospectionException,IllegalAccessException,IllegalArgumentException,InvocationTargetException;
}
