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
public interface IWriter<T> {

    void writeThisObjectToFile(String filePath, List<T> data) throws IOException,IntrospectionException,IllegalAccessException,IllegalArgumentException,InvocationTargetException;
}
