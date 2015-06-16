package com.woyo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public class Constants {

    //page size
    public static final int MAX_PAGE_SIZE = Integer.parseInt(ResourceLoader.getInstance().getString("page.page_size"));

    public static final Map<Integer, String> USER_TYPE_MAP = new HashMap<Integer, String>();

}
