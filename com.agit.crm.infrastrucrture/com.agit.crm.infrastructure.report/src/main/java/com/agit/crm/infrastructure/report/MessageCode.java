package com.agit.crm.infrastructure.report;

/**
 *
 * @author bayutridewanto
 */
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

public class MessageCode implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(MessageCode.class);

    private static final long serialVersionUID = 1L;

    /**
     * Generic success
     */
    public static final MessageCode M_GENERIC_SUCCESS = new MessageCode(null, "GENERIC", "SUCCESS", false);

    /**
     * Generic error (only for unexpected errors)
     */
    public static final MessageCode E_GENERIC_ERROR = new MessageCode(null, "GENERIC", "ERROR", true);

    private static final ConcurrentHashMap<String, MessageCode> _MSGMAP = new ConcurrentHashMap<>();

    /**
     * Get key from specified parameters
     *
     * @param sourceCls source class simple name
     * @param methodName method name
     * @param suffix a suffix
     * @param error true if error message
     * @return the message key (Examples: E.ExampleManager.createExample.1 -
     * error, M.ExampleManager.createExample.1 - non error message)
     */
    public static String generateKey(Class<?> sourceCls, String methodName, String suffix, boolean error) {
        StringBuilder codeBuild = new StringBuilder(error ? "E" : "M");
        if (sourceCls != null) {
            if (codeBuild.length() > 0) {
                codeBuild.append("_");
            }
            codeBuild.append(sourceCls.getSimpleName());
        }
        if (methodName != null) {
            if (codeBuild.length() > 0) {
                codeBuild.append("_");
            }
            codeBuild.append(methodName.trim());
        }
        if (suffix != null) {
            if (codeBuild.length() > 0) {
                codeBuild.append("_");
            }
            codeBuild.append(suffix.trim());
        }
        if (codeBuild.length() == 0) {
            throw new RuntimeException("Illegal message code!");
        }
        return codeBuild.toString();
    }

    private String key;

    private MessageCode(Class<?> sourceCls, String methodName, String suffix, boolean error) {
        this.key = generateKey(sourceCls, methodName, suffix, error);
    }

    private MessageCode(String key) {
        this.key = key;
    }

    /**
     * Create or get existing
     *
     * @param sourceCls source class
     * @param methodName method name
     * @param suffix suffix
     * @param error error
     * @return message code
     */
    public static MessageCode get(Class<?> sourceCls, String methodName, String suffix, boolean error) {
        if (sourceCls == null || methodName == null) {
            throw new IllegalArgumentException("sourceCls and methodName must be defined!!!");
        }
        String k = generateKey(sourceCls, methodName, suffix, error);
        return getByKey(k);
    }

    /**
     * Convenient method to create MessageCode without suffix
     *
     * @param sourceCls
     * @param methodName
     * @param error
     * @return
     */
    public static MessageCode get(Class<?> sourceCls, String methodName, boolean error) {
        return get(sourceCls, methodName, null, true);
    }

    /**
     * Get message key
     *
     * @return
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Get MessageCode by key
     *
     * @param k
     * @return MessageCode object
     */
    public static MessageCode getByKey(String k) {
        MessageCode mc = _MSGMAP.get(k);
        if (mc == null) {
            mc = new MessageCode(k);
            _MSGMAP.put(k, mc);
        }
        return mc;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MessageCode other = (MessageCode) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.key;
    }

    private static MessageSource[] _msgSrcs = null;

    static void setMessageSources(Collection<MessageSource> messageSources) {
        if (_msgSrcs == null) {
            _msgSrcs = messageSources.toArray(new MessageSource[messageSources.size()]);
        }
    }

    /**
     * Get message text
     *
     * @param msgParams
     * @param locale specified locale
     * @return if no message found, return the code itself
     */
    public String getMessage(Object[] msgParams, Locale locale) {
        return getMessage(this.key, msgParams, this.key, locale);
    }

    /**
     * Get message text with default locale
     *
     * @param msgParams
     * @return
     */
    public String getMessage(Object[] msgParams) {
        return getMessage(this.key, msgParams, this.key, null);
    }

    /**
     * Get message
     *
     * @param locale with locale
     * @return message text
     */
    public String getMessage(Locale locale) {
        return getMessage(this.key, (Object[]) null, this.key, locale);
    }

    /**
     * Get message with no parameter and default locale
     *
     * @return message text
     */
    public String getMessage() {
        return getMessage(this.key, (Object[]) null, this.key, (Locale) null);
    }

    /**
     * Get message from locale
     *
     * @param msgKey message key
     * @param msgParams params
     * @param defaultMsg default message
     * @param locale locale
     * @return message text
     */
    public static String getMessage(String msgKey, Object[] msgParams, String defaultMsg, Locale locale) {
        final boolean debugEnabled = logger.isDebugEnabled();
        if (_msgSrcs != null && _msgSrcs.length > 0) {
            if (locale == null) {
                locale = Locale.getDefault();
            }
            for (MessageSource ms : _msgSrcs) {
                try {
                    return ms.getMessage(msgKey, msgParams, locale);
                } catch (NoSuchMessageException nsme) {
//                    continue;
                }
            }
            if (debugEnabled) {
                logger.debug("****Message " + msgKey + " is not found in available message sources");
            }
        } else if (debugEnabled) {
            logger.debug("****No message source available");
        }
        if (defaultMsg == null) {
            return null;
        }
        return MessageFormat.format(defaultMsg, msgParams);
    }
}
