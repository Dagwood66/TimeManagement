package cn.lizihao.timemanagement.utils;

import android.content.Context;

import com.google.gson.Gson;

/**
 * by 2016-11-03 14:27
 */
public class ResourceUtils {
    private static Context mContext = UIUtils.getContext();
    private static Gson gson = new Gson();

    public static String getString(int id) {
        return mContext.getResources().getString(id);
    }

    public static String getString(int id, Object... formatArgs) {
        return mContext.getResources().getString(id, formatArgs);
    }
}
