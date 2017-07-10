package com.agit.crm.infrastructure.component;

import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public interface IFFReader<T> {

    List<T> getJavaObjectFromThisFile(String filePath) throws FileNotFoundException;

    List<T> getJavaObjectfromThisStream(String relativeFilePath);
}
