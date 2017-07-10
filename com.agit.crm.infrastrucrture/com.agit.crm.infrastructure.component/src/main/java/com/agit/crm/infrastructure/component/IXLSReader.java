package com.agit.crm.infrastructure.component;

import java.beans.IntrospectionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public interface IXLSReader <T> {

    List<T> getJavaObjectFromThisFile(String filePath) throws FileNotFoundException,IOException,IntrospectionException,IllegalAccessException,IllegalArgumentException,InvocationTargetException,InstantiationException;

    List<T> getJavaObjectfromThisStream(String relativeFilePath, Class<T> record);
}
