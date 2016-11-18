package cn.lizihao.timemanagement.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * by 2016-10-08 11:25
 */
public class FileUtils {
    public static String getString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while (null != (s = bufferedReader.readLine())) {
            stringBuilder.append(s);
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}
