package com.example.demo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created on 18/10/22
 *
 * @author wb
 */
public class ParamsUtil {
    /**
     * 将url参数转换成map
     *
     * @param param aa=11&bb=22&cc=33
     * @return
     */
    public static Map<String, List<String>> getUrlParams(String param) {
        String split = "&";
        return getUrlParams(param, split);
    }

    public static Map<String, List<String>> getUrlParams(String param, String split) {
        Map<String, List<String>> map = new HashMap<String, List<String>>(0);
        if ("".equals(param) || param == null) {
            return map;
        }
        String[] params = param.split(split);
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], Arrays.asList(p[1]));
            }
        }
        return map;
    }

    public static String currentTimestamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date());
    }
}
