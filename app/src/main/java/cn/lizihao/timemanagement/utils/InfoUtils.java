package cn.lizihao.timemanagement.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

/**
 * Android 常用配置信息封装类
 */
public class InfoUtils {

    /**
     * 返回手机IMEI号
     *
     * @return Android IMEI
     */
    public static String getDeviceId() {
        TelephonyManager telephonyManager = (TelephonyManager) UIUtils.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }


    /**
     * 获取手机号码
     *
     * @return 空串或手机号码(11位)
     */
    public static String getLine1Number() {
        TelephonyManager telephonyManager = (TelephonyManager) UIUtils.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        String line1Number = telephonyManager.getLine1Number();
        if ((line1Number != null) && (!line1Number.isEmpty())) {
            int length = line1Number.length();
            if (length > 11) {
                line1Number = line1Number.substring(length - 11);
            }
        } else {
            line1Number = "";
        }
        return line1Number;
    }

    /**
     * 获取版本号
     *
     * @return 当前应用版本号
     * @throws PackageManager.NameNotFoundException
     */
    public static int getVersionCode() throws PackageManager.NameNotFoundException {
        PackageManager packageManager = UIUtils.getContext().getPackageManager();
        //0代表获取版本号
        PackageInfo packageInfo = packageManager.getPackageInfo(UIUtils.getContext().getPackageName(), 0);
        return packageInfo.versionCode;
    }

    /**
     * 获取版本名称
     *
     * @return 当前应用版本名称
     * @throws PackageManager.NameNotFoundException
     */
    public static String getVersionName() throws PackageManager.NameNotFoundException {
        PackageManager packageManager = UIUtils.getContext().getPackageManager();
        //0代表获取版本号
        PackageInfo packageInfo = packageManager.getPackageInfo(UIUtils.getContext().getPackageName(), 0);
        return packageInfo.versionName;
    }

}
