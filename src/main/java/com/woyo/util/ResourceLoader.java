package com.woyo.util;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * @author Administrator
 *
 */
public class ResourceLoader {
    private static final String ENCODING_GBK = "GBK";
    private static final String ENCODING_ISO = "ISO-8859-1";
    private String filename = "system_config"; //default config file
    private Locale locale = new Locale("en", "US");
    private ResourceBundle bundle;

    private ResourceLoader(String filename, Locale locale) {
        if (filename != null) {
            this.filename = filename;
        }
        if (locale != null) {
            this.locale = locale;
        }

        bundle = ResourceBundle.getBundle(this.filename, this.locale);
    }

    public static synchronized ResourceLoader getInstance() {
        return new ResourceLoader(null, null);
    }

    public static synchronized ResourceLoader getInstance(String filename) {
        return new ResourceLoader(filename, null);
    }

    public static synchronized ResourceLoader getInstance(String filename, Locale locale) {
        return new ResourceLoader(filename, locale);
    }

    public synchronized void setLocale(Locale locale) {
        if (locale == null || this.locale.equals(locale)) {
            return;
        }

        bundle = ResourceBundle.getBundle(filename, locale);
    }

    public String getString(String key) {
        return bundle.getString(key);
    }

    public String getGBKString(String key) throws UnsupportedEncodingException {
        return iso2gbk(getString(key));
    }

    public Enumeration<String> getKeys() {
        return bundle.getKeys();
    }

    public Map<String, String> getKeyValueMap() {
        Enumeration<String> enu = this.getKeys();
        Map<String, String> map = new TreeMap<String, String>();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            map.put(key, this.getString(key));
        }

        return map;
    }

    public static String iso2gbk(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        } else {
            return new String(str.getBytes(ENCODING_ISO), ENCODING_GBK);
        }

    }

    public static String gbk2iso(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        } else {
            return new String(str.getBytes(ENCODING_GBK), ENCODING_ISO);
        }
    }
}