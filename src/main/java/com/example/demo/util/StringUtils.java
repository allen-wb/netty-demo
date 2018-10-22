package com.example.demo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on 18/10/22
 *
 * @author wb
 */
public class StringUtils {

    public static String buildQueryParams(Map<String, String> params) {
        return params.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .reduce((a, b) -> a + "&" + b)
                .orElse("");
    }

    public static Map<String, String> parseForm(String form) {
        return Arrays.stream(form.split("&"))
                .map(s -> s.split("="))
                .filter(arr -> arr.length == 2)
                .collect(Collectors.toMap(arr -> arr[0].trim(), arr -> arr[1].trim()));
    }

    public static boolean allNotNull(String... strArr) {
        return Arrays.stream(strArr).allMatch(s -> null != s && !"".equals(s));
    }

    public static String urlEncodeUTF8(String s) {
        String result = s;
        try {
            result = URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException ignored) {
        }
        return result;
    }

}
