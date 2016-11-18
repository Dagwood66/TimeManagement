package cn.lizihao.timemanagement.global;

import android.app.Application;
import android.content.Context;

/**
 * by 2016-09-23 12:08
 */
public class GlobalApplication extends Application {
    private static Context applicationContext;
    public static final String WEBSERVER_URL = "http://ws.gzh-bds.top/chrgsvr.asmx";
    public static final String WEBSERVER_NAMESPACE = "http://gzh-bds.top/";
    public static final String UPADTE_URL = "http://app.gzh-bds.top/hfapp/version.json";
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }

    public static Context getGlobalContext() {
        return applicationContext;
    }

}
