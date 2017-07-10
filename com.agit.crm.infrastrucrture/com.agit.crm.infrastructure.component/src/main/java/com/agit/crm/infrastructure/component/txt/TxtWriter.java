package com.agit.crm.infrastructure.component.txt;

import com.ancientprogramming.fixedformat4j.format.FixedFormatManager;
import com.ancientprogramming.fixedformat4j.format.impl.FixedFormatManagerImpl;
import com.agit.crm.infrastructure.component.IFFWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 *
 * @author bayutridewanto
 */
public class TxtWriter<T> implements IFFWriter<T> {
    
    private FixedFormatManager manager = null;
    
    private static final String EOL = "\n";
    
    private Class<T> clazz;    

    public TxtWriter(Class<T> clazz) {
        this.clazz = clazz;
        manager = new FixedFormatManagerImpl();
    }

    @Override
    public void writeThisObjectToFile(List<T> data, String fileName) throws IOException {

        /*open file writer*/
        File f = createFile(fileName);

        /*memori operations*/
        FileWriter fw = new FileWriter(f.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        /*convert bean T to string*/
        for (T o : data) {
            bw.write(manager.export(o)+ EOL);
        }
        
        bw.close();
        /*write to disk*/
    }
    
    /*create a file*/
    private File createFile(String absolutePath) throws IOException {
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    @Override
    public byte[] writeThisObjectToStream(List<T> data) throws IOException {
        
        /*prepare for writer*/
        StringWriter sw = new StringWriter();
        
        /*convert bean T to string*/
        for (T o : data) {
            sw.write(manager.export(o)+ EOL);
        }
        /*convert it to UTF-8 (default UTF-ANSI)*/
        return sw.toString().getBytes("UTF-8");
    }

}
