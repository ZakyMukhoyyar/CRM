package com.agit.crm.infrastructure.component.csv.ff;

import com.ancientprogramming.fixedformat4j.format.FixedFormatManager;
import com.ancientprogramming.fixedformat4j.format.impl.FixedFormatManagerImpl;
import com.agit.crm.infrastructure.component.IFFReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bayutridewanto
 * @param <T>
 */
public class FFReader<T> implements IFFReader<T> {
    
    private final Class<T> clazz;

    private FixedFormatManager manager = null;

    public FFReader(Class<T> clazz) {
        this.clazz = clazz;
        manager = new FixedFormatManagerImpl();
    }
    
    @Override
    public List<T> getJavaObjectFromThisFile(String filePath) throws FileNotFoundException {

        List<T> o = new ArrayList();

        /*Create file stream*/
        List<String> tmp = getArrayOfStringOfThisFile(filePath);

        /*convert list of string into list of control bean*/
        for (String s : tmp) {
            o.add(manager.load(clazz, s));
        }

        return o;
    }

    @Override
    public List<T> getJavaObjectfromThisStream(String relativeFilePath) {
        List<T> o = new ArrayList();

        /*Create file stream*/
        List<String> tmp = getArrayOfStringOfThisStream(relativeFilePath);

        /*convert list of string into list of control bean*/
        for (String s : tmp) {
            o.add(manager.load(clazz, s));
        }

        return o;
    }

    /*convert resource stream of file into list of string*/
    private List<String> getArrayOfStringOfThisStream(String relativeFilePath) {
        List<String> inStr = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(relativeFilePath), "UTF-8"));
            /*read line by line*/
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inStr.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return inStr;
    }

    
    /*convert file stream of file into list of string*/
    public List<String> getArrayOfStringOfThisFile(String filePath) {
        List<String> inStr = new ArrayList();
        try {
            File file = new File(filePath);
            try (FileReader fileReader = new FileReader(file)) {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                /*read line by line*/
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    inStr.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return inStr;
    }

}
