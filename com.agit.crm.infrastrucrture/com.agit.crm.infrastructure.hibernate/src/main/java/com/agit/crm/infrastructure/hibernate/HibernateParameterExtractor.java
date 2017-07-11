package com.agit.crm.infrastructure.hibernate;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HibernateParameterExtractor
 * @author bayutridewanto
 */
public class HibernateParameterExtractor {
    private static final Pattern hibernatePattern = Pattern.compile("[\\:]([a-zA-Z_]+).*");
    
    public static Set<String> getParameters(String query) {
        Set<String> result = new HashSet<>();
        if (query != null) {
            Matcher hibernateMatcher = hibernatePattern.matcher(query);
            while (hibernateMatcher.find()) {
                result.add(hibernateMatcher.group(1));
            }
        }
        return result;
    }
    
}