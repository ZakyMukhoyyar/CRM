package com.agit.crm.infrastructure.component;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public interface IMDBWriter<T> {

    void writeThisObjectToFile(List<T> data, String fileName) throws IOException, SQLException,IntrospectionException,IllegalAccessException,IllegalArgumentException,InvocationTargetException;
}
