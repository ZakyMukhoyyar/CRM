package com.agit.crm.acm.api.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.activiti.engine.identity.Group;
import org.activiti.engine.runtime.ClockReader;

/**
 *
 * @author lintang
 */
public class ACMGroupCache {

    private final ClockReader clockReader;
    protected Map<String, ACMGroupCacheEntry> groupCache;
    protected long expirationTime;
    protected ACMGroupCacheListener acmCacheListener;

    public ACMGroupCache(final int cacheSize, ClockReader clockReader, long expirationTime) {
        this.clockReader = clockReader;
        this.expirationTime = expirationTime;
        this.groupCache = new LinkedHashMap<String, ACMGroupCache.ACMGroupCacheEntry>(cacheSize + 1, 0.75f, true) {

            private static final long serialVersionUID = 5207574193173514579L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, ACMGroupCacheEntry> eldest) {
                boolean removeEldest = size() > cacheSize;
                if (removeEldest && acmCacheListener != null) {
                    acmCacheListener.cacheEviction(eldest.getKey());
                }
                return removeEldest;
            }

        };
        this.expirationTime = expirationTime;
    }

    /*logic*/
    public void add(String userId, List<Group> groups) {
        this.groupCache.put(userId, new ACMGroupCacheEntry(clockReader.getCurrentTime(), groups));
    }

    public List<Group> get(String userId) {
        ACMGroupCacheEntry cacheEntry = groupCache.get(userId);
        if (cacheEntry != null) {
            if ((clockReader.getCurrentTime().getTime() - cacheEntry.getTimestamp().getTime()) < expirationTime) {

                if (acmCacheListener != null) {
                    acmCacheListener.cacheHit(userId);
                }

                return cacheEntry.getGroups();

            } else {

                this.groupCache.remove(userId);

                if (acmCacheListener != null) {
                    acmCacheListener.cacheExpired(userId);
                    acmCacheListener.cacheEviction(userId);
                }

            }
        }

        if (acmCacheListener != null) {
            acmCacheListener.cacheMiss(userId);
        }

        return null;
    }

    public void clear() {
        groupCache.clear();
    }

    public Map<String, ACMGroupCacheEntry> getGroupCache() {
        return groupCache;
    }

    public void setGroupCache(Map<String, ACMGroupCacheEntry> groupCache) {
        this.groupCache = groupCache;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public ACMGroupCacheListener getACMCacheListener() {
        return acmCacheListener;
    }

    public void setACMCacheListener(ACMGroupCacheListener acmCacheListener) {
        this.acmCacheListener = acmCacheListener;
    }

    /*helper*/
    public static interface ACMGroupCacheListener {

        void cacheHit(String userId);

        void cacheMiss(String userId);

        void cacheEviction(String userId);

        void cacheExpired(String userId);

    }

    static class ACMGroupCacheEntry {

        protected Date timestamp;
        protected List<Group> groups;

        public ACMGroupCacheEntry() {

        }

        public ACMGroupCacheEntry(Date timestamp, List<Group> groups) {
            this.timestamp = timestamp;
            this.groups = groups;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        public List<Group> getGroups() {
            return groups;
        }

        public void setGroups(List<Group> groups) {
            this.groups = groups;
        }

    }
}
