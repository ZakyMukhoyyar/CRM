package com.agit.crm.infrastructure.component;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public interface IReader<T> {

    List<T> getJavaObjectFromThisFile(String pathFile) throws FileNotFoundException;

    List<T> getJavaObjectfromThisStream(InputStreamReader isr);
}
