package cn.lizihao.timemanagement.utils;

import android.util.Log;

import java.util.List;

/**
 * 打印调试信息
 */
public class LogUtils {
    /**
     * 打印开关
     */
    private static boolean isOpen = true;

    public static void d(String tag, String msg) {
        if (isOpen) {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String methodName, String title, String value) {
        if (isOpen) {
            Log.d(tag, "方法名：" + methodName + "\n" +
                    "标题：" + title + "\n" +
                    "内容：" + value);
        }
    }

    public static <T> void d(String tag, String methodName, String title, List<T> list) {
        if (isOpen) {
            Log.d(tag, "方法名：" + methodName + "\n" +
                    "标题：" + title + "\n" +
                    "内容：size:" + list.size());
            for (int i = 0, len = list.size(); i < len; i++) {
                Log.d(tag, "\t\t" + "条目" + i + ":" + list.get(i).toString());
            }
        }
    }

    public static void d(String tag, String methodName, String title, byte[] bytes) {
        if (isOpen) {
            Log.d(tag, "方法名：" + methodName + "\n" +
                    "标题：" + title + "\n" +
                    "内容：");
            for (byte t : bytes) {
                Log.d(tag, "\t\t" + t);
            }
        }
    }

    public static void d(String tag, String methodName, String title, Object[] objects) {
        if (isOpen) {
            Log.d(tag, "方法名：" + methodName + "\n" +
                    "标题：" + title + "\n" +
                    "内容：");
            for (Object o : objects) {
                Log.d(tag, "\t\t" + o.toString());
            }
        }
    }










































    public static void i(String tag, String msg) {
        if (isOpen) {
            Log.i(tag, msg);
        }
    }

    public static void i(String tag, String methodName, String title, String value) {
        if (isOpen) {
            Log.i(tag, "方法名：" + methodName + "\n" +
                    "标题：" + title + "\n" +
                    "内容：" + value);
        }
    }

    public static <T> void i(String tag, String methodName, String title, List<T> list) {
        if (isOpen) {
            Log.i(tag, "方法名：" + methodName + "\n" +
                    "标题：" + title + "\n" +
                    "内容：size:" + list.size());
            for (int i = 0, len = list.size(); i < len; i++) {
                Log.i(tag, "\t\t" + "条目" + i + ":" + list.get(i).toString());
            }
        }
    }

    public static void i(String tag, String methodName, String title, byte[] bytes) {
        if (isOpen) {
            Log.i(tag, "方法名：" + methodName + "\n" +
                    "标题：" + title + "\n" +
                    "内容：");
            for (byte t : bytes) {
                Log.i(tag, "\t\t" + t);
            }
        }
    }

    public static void i(String tag, String methodName, String title, Object[] objects) {
        if (isOpen) {
            Log.i(tag, "方法名：" + methodName + "\n" +
                    "标题：" + title + "\n" +
                    "内容：");
            for (Object o : objects) {
                Log.i(tag, "\t\t" + o.toString());
            }
        }
    }



    /**
     * 获取当前行数
     *
     * @return 返回当前行数
     */
    public static int getLineNumber() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace[1].getLineNumber();
    }

}
