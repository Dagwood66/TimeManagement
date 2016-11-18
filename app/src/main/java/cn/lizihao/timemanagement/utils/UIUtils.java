package cn.lizihao.timemanagement.utils;

import android.content.Context;

import cn.lizihao.timemanagement.global.GlobalApplication;


/**
 * UI操作类
 */
public class UIUtils {
    /**
     * 获取全局上下文
     *
     * @return 返回全局上下文
     */
    public static Context getContext() {
        return GlobalApplication.getGlobalContext();
    }

    /**
     * dp转换为像素
     *
     * @param dp dp
     * @return 对应像素
     */
    public static int Dp2Px(int dp) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
