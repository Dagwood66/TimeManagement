package cn.lizihao.timemanagement.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class DialogUtils {

    public static AlertDialog showMessageDialog(Activity activity, String message) {
        return showMessageDialog(activity, message, null, true);
    }

    public static AlertDialog showMessageDialog(Activity activity, String message, DialogInterface.OnClickListener onClickListener, Boolean mode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        return builder.setTitle("提示").setMessage(message).setPositiveButton("确定", onClickListener).setCancelable(mode).show();
    }

    public static AlertDialog showMessageDialog(Activity activity, String message, Boolean mode) {
        return showMessageDialog(activity, message, null, mode);
    }

    public static void showForceMessageDialog(Activity activity, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("提示").setMessage(message).setCancelable(false).setPositiveButton("确定", onClickListener).show();
    }

    public static AlertDialog showUpdateSleep(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        return builder.setTitle("提示").setMessage("更新中。。。").setCancelable(false).show();
    }

    public static void showSelectDialog(Activity activity, String message,
                                        DialogInterface.OnClickListener onClickListenerPositive,
                                        DialogInterface.OnClickListener onClickListenerNegative,
                                        Boolean mode) {
        showSelectDialog(activity, "提示", message, onClickListenerPositive, onClickListenerNegative, mode);

    }

    public static void showSelectDialog(Activity activity, String title, String message,
                                        DialogInterface.OnClickListener onClickListenerPositive,
                                        DialogInterface.OnClickListener onClickListenerNegative, Boolean mode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("确定", onClickListenerPositive)
                .setNegativeButton("取消", onClickListenerNegative)
                .setCancelable(mode)
                .show();
    }

    public static void showSelectDialog(Activity activity, String message,
                                        DialogInterface.OnClickListener onClickListenerPositive,
                                        DialogInterface.OnClickListener onClickListenerNegative) {
        showSelectDialog(activity, "提示", message, onClickListenerPositive, onClickListenerNegative, true);
    }
}
