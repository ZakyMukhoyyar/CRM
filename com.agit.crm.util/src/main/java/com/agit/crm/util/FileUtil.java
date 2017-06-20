package com.agit.crm.util;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author bitozen
 */
public class FileUtil {

    public static String[] getFilesWithFileNameLike(final CharSequence containingString, String dirPath) {
        String[] list = new File(dirPath).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains(containingString);
            }
        });

        return list;
    }
}
