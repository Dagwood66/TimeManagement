package cn.lizihao.timemanagement.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 * by 2016-09-13 9:23
 */
public class StringUtils {
    private static final String TAG = StringUtils.class.getName();

    /**
     * 判断字符串为空或长度为零
     *
     * @param s String
     * @return 字符串为空或长度为零返回true
     */
    public static boolean isNull(String s) {
        if (s != null) {
            if (!s.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static String removeRepeatSpance(String s) {
        List<String> strings = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            strings.add(c + "");
        }
        if (strings.size() >= 2) {
            StringBuilder stringBuilder = new StringBuilder(strings.get(0));
            for (int i = 1; i < strings.size(); i++) {
                if (strings.get(i).equals(" ") && strings.get(i).equals(strings.get(i - 1))) {
                    strings.remove(i);
                    --i;
                } else {
                    stringBuilder.append(strings.get(i));
                }
            }
            return stringBuilder.toString();
        }
        return s;
    }
}
