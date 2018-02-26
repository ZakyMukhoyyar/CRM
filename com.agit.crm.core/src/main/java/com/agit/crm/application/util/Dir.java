package com.agit.crm.application.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import javax.management.monitor.Monitor;

/**
 *
 * @author SembiringiO
 */
public class Dir implements FilenameFilter {

    String path;
    public FileFilter filter;
    String file_separator = ";";

    public Dir(String path_filter) {
        if (path_filter.indexOf('*') != -1) {
            int index = path_filter.lastIndexOf(file_separator);
            if (index != -1) {
                path = path_filter.substring(0, index);
                filter = new FileFilter(path_filter.substring(index + 1));
            } else {
                path = "." + file_separator;
                filter = new FileFilter(null);
            }
        } else {
            path = path_filter;
            filter = new FileFilter(null);
        }

    }

    public Dir(String path, String filter) {
        this.path = path == null || path.length() == 0 ? "." + file_separator : path;
        this.filter = new FileFilter(filter);
    }

    public boolean accept(File file, String name) {
        boolean p = filter.prefix(name);
        boolean s = filter.suffix(name);
        //File theFile = new File(path, name);
        //System.out.println(theFile.getName());
        //if (!isReady(theFile)) return false;
        return p && s;
    }

    public File[] listFiles() {
        File test_dir = new File(path);
        if (!test_dir.exists()) {
            throw new RuntimeException("Path not found '" + path + "'...");
        }
        File dir = new File(path);
        return dir.listFiles(this);
    }

    public static File[] list(String path_filter) {
        Dir dir = new Dir(path_filter);
        return dir.listFiles();
    }

    public static File[] list(String path, String filter) {
        Dir dir = new Dir(path, filter);
        return dir.listFiles();
    }

    public File[] listFilesByDate() {
        File test_dir = new File(path);
        if (!test_dir.exists()) {
            throw new RuntimeException("Path not found '" + path + "'...");
        }
        File dir = new File(path);
        File[] files = dir.listFiles(this);

        TreeMap sort = new TreeMap();
        for (int i = 0; i < files.length; i++) {
            sort.put(new Long(files[i].lastModified()), files[i]);
        }

        java.util.Iterator ite = sort.keySet().iterator();
        File[] filesbydate = new File[sort.size()];

        int count = 0;
        while (ite.hasNext()) {
            Long key = (Long) ite.next();
            filesbydate[count] = (File) sort.get(key);
            count++;
        }
        return filesbydate;
    }

    public static File[] listByDate(String path_filter) {
        Dir dir = new Dir(path_filter);
        return dir.listFilesByDate();
    }

    public static File[] listByDate(String path, String filter) {
        Dir dir = new Dir(path, filter);
        return dir.listFilesByDate();
    }

    public static File setFileExtension(File file, String s) {
        String name = file.getAbsolutePath();
        String ext = s.startsWith(".") ? s : "." + s;
        int index = name.lastIndexOf(".");
        String new_name = index == -1 ? name + ext : name.substring(0, index) + ext;
        File new_file = new File(new_name);
        if (new_file.exists()) {
            new_file.delete();
        }
        if (file.renameTo(new_file)) {
            file = new_file;
        }
        return file;
    }

    public static File move(File source, File target, Monitor monitor) throws Exception {
        if (source.getAbsolutePath().equals(target.getAbsolutePath())) {
            return target;
        }
        if (target.exists()) {
            target.delete();
        }
        boolean success = source.renameTo(target);
        if (success) {
            return target;
        } else {
            copy(source, target);
            source.delete();
            return target;
        }
    }

    public static File move(File source, File target) throws Exception {

        return move(source, target, null);
    }

    public static File move(File source, String target_path, Monitor monitor) throws Exception {
        return move(source, new File(target_path, source.getName()), monitor);
    }

    public static File move(File source, String target_path) throws Exception {
        return move(source, target_path, null);
    }

    public static File copy(File source, File target) throws Exception {
        if (source.getAbsolutePath().equals(target.getAbsolutePath())) {
            return source;
        }
        FileInputStream in = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(target, false);
        byte buf[] = new byte[1024];
        int len;
        long count = 0;
        while ((len = in.read(buf)) != -1) {
//            if (monitor != null) {
//				if (monitor.cancelled()) return null;
//				monitor.progress(pos, max);
//            }
            out.write(buf, 0, len);
            count += len;
        }
//        if (monitor != null) {
//            monitor.progress(pos, max);
//        }
        out.close();
        in.close();
        return target;
    }

//    public static File copy(File source, File target) throws Exception {
//
//        return copy(source, target);
//    }
    public static File rename(File source, File target, Monitor monitor) throws Exception {
        return move(source, target, monitor);
    }

    public static File rename(File source, File target) throws Exception {
        return rename(source, target, null);
    }

    public static File rename(File source, String target_path, String prefix, String suffix, Monitor monitor) throws Exception {
        String p = prefix == null ? "" : prefix;
        String s = suffix == null ? "" : suffix;
        String n = source.getName();
        File target = new File(target_path, p + n + s);
        if (target.exists()) {
            target.delete();
        }
        return move(source, target, monitor);
    }

    public static File rename(File source, String target_path, String prefix, String suffix) throws Exception {
        return rename(source, target_path, prefix, suffix, null);
    }

    public static String substract(String s) {
        int index = s.lastIndexOf(".");
        return index == -1 ? s : s.substring(0, index);
    }

    public static String substract(String s, String ext) {
        int index = s.lastIndexOf(".");
        String x = ext.startsWith(".") ? ext : "." + ext;
        return index == -1 ? s + x : s.substring(0, index) + x;
    }

    public static String substractPlusExt(String s, String ext) {
        //int index = s.lastIndexOf(".");
        //String x = ext.startsWith(".")? ext: "." + ext;
        //return index==-1? s + x: s.substring(0, index) + x;
        return s + ext;
    }

    public static String substractSCP(String s, String nodeID, String timeStamp) {
        //int index = s.lastIndexOf(".");
        //String x = ext.startsWith(".")? ext: "." + ext;
        //return index==-1? s + x: s.substring(0, index) + x;
        return nodeID + "." + s + "_" + timeStamp;
    }

    public static String substract(File file) {
        return substract(file.getAbsolutePath());
    }

    public static String substract(File file, String ext) {
        return substract(file.getAbsolutePath(), ext);
    }

    public static boolean isReady(File file, long delay) {
        long old_size = file.length();
        try {
            Thread.sleep(delay);
            File new_file = new File(file.getAbsolutePath());
            return new_file.length() == old_size;

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isReady(File file) {
        return isReady(file, 1000);
    }

    public static String[] getListFiles(String strDirList) {
        ArrayList alFiles = new ArrayList();
        StringTokenizer stDirList = new StringTokenizer(strDirList, "\n");

        while (stDirList.hasMoreTokens()) {
//            do nothing
        }
        alFiles.trimToSize();

        String[] strFiles = new String[alFiles.size()];
        for (int i = 0; i < alFiles.size(); i++) {
            strFiles[i] = alFiles.get(i).toString();
        }

        return strFiles;
    }

    public static void main(String arg[]) {
        /*
		Dir d0 = new Dir(null, null);
		Dir d1 = new Dir(null, "");
		Dir d2 = new Dir(null, "*");
		Dir d3 = new Dir(null, "*.");
		Dir d4 = new Dir(null, ".");
		Dir d5 = new Dir(null, "*.txt");
		Dir d6 = new Dir(null, "SMS*");
		Dir d7 = new Dir(null, "SMS*.txt");
		Dir d8 = new Dir(null, "AB*.txt");
         */
        String path = "D://temp//";
        String filter = "\\b\\w+_\\w+\\b.csv";
        File[] list = Dir.listByDate(path, filter);
        for (int index = 0; index < list.length; index++) {
            File file = list[index];
            System.out.println(file.getName());
        }
    }
}
