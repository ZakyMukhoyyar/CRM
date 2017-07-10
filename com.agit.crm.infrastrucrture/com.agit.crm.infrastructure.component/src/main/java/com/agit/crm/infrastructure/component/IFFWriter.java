package com.agit.crm.infrastructure.component;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public interface IFFWriter<T> {

    void writeThisObjectToFile(List<T> data, String fileName) throws IOException;
    
    byte[] writeThisObjectToStream(List<T> data) throws IOException;
}
