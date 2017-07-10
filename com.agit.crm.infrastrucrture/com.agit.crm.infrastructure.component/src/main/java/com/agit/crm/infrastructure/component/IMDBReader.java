package com.agit.crm.infrastructure.component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public interface IMDBReader<T> {

    List<T> getJavaObjectFromThisFile(String filePath, String tableName) throws FileNotFoundException, IOException,InstantiationException,IllegalAccessException,IllegalArgumentException,InvocationTargetException;

    List<T> getJavaObjectfromThisStream(String relativeFilePath, Class<T> record);
}
