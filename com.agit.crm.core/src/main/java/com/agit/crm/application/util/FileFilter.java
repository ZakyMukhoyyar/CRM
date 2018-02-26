package com.agit.crm.application.util;

/**
 *
 * @author SembiringiO
 */
public class FileFilter {

    public String prefix;
    public String suffix;

    public FileFilter(String pattern) {
        setFilter(pattern);
    }

    public void setFilter(String s) {
        prefix = null;
        suffix = null;
        if ((s == null) || (s.length() == 0)) {
            return;
        }
        if (s.equals("") || s.equals(".") || s.equals(".") || s.equals(".*")) {
            return;
        }
        int index = s.lastIndexOf(".");
        if (index == -1) {
            int pos = s.indexOf("*");
            switch (pos) {
                case -1:
                    prefix = s;
                    break;
                case 0:
                    prefix = pos != s.length() ? s.substring(1) : null;
                    break;
                default:
                    prefix = s.substring(0, pos);
                    break;
            }
        } else {
            String prefix_str = s.substring(0, index);
            int prefix_pos = prefix_str.indexOf("*");
            switch (prefix_pos) {
                case -1:
                    prefix = prefix_str;
                    break;
                case 0:
                    prefix = prefix_str.length() == 1 ? null : prefix_str.substring(1);
                    break;
                default:
                    prefix = prefix_str.substring(0, prefix_pos);
                    break;
            }
            String suffix_str = s.substring(index);
            int suffix_pos = suffix_str.indexOf("*");
            switch (suffix_pos) {
                case -1:
                    suffix = suffix_str;
                    break;
                case 0:
                    suffix = suffix_str.substring(1);
                    break;
                default:
                    suffix = suffix_str.substring(suffix_pos);
                    break;
            }
        }
    }

    public boolean prefix(String s) {
        Boolean prf = true;
        if (prefix != null) {
            prf = s.startsWith(prefix);
        }
        return prf;
    }

    public boolean suffix(String s) {
        Boolean sfx = true;
        if (prefix != null) {
            sfx = s.endsWith(suffix);
        }
        return sfx;
    }

    public boolean accept(String s) {
        return prefix(s) && suffix(s);
    }
}
