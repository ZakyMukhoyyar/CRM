package com.agit.crm.infrastructure.component.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author bayutridewanto
 */
public class StreamUtils {

    /**
     * 
     * @param filePath c:\\data\\input-file.txt
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static InputStream getStreamFromFile(String filePath) throws FileNotFoundException, IOException {
        InputStream input = new FileInputStream(filePath);
        int data = input.read();
        while (data != -1) {
            data = input.read();
        }
        return input;
    }
    
    /**
     * 
     * @param filePath c:\\data\\output-file.txt
     * @return
     * @throws java.io.FileNotFoundException
     */
    public static OutputStream getOutputStreamFromFile(String filePath) throws FileNotFoundException, IOException {
        OutputStream output = new FileOutputStream(filePath);
        output.write("Hello World".getBytes());
        output.close();
        return null;
    }
}
