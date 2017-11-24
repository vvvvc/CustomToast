package com.example.vvvvvc.customtoast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * 各种效果toast
 *
 * @param
 */
public class ToastUtil {
    private static Toast toast;
    private static Toast toast2;
    private static Toast toast3;
    private static Toast toast4;
    private static ImageView imageCodeProject;

    //标准toast
    public static void showToast(Context context,String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);//如果不为空，则直接改变当前toast的文本
        }
        toast.show();
    }

    //	中间位置toast
    public static void centerToast(final Context context, final String text) {
        ThreadUtils.runOnMainThread(new Runnable() {
            @Override
            public void run() {
                if (toast2 == null) {
                    toast2 = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast2.setGravity(Gravity.CENTER, 0, 0);
                } else {
                    toast2.setText(text);//如果不为空，则直接改变当前toast2的文本
                }
                toast2.show();
            }
        });

    }

    //    带图片的Toast
    public static void picToast(Context context,String text, int code) {

        LinearLayout toast3View = (LinearLayout) toast3.getView();
        ImageView imageCodeProject = new ImageView(context);
        if (code == 0) {
            imageCodeProject.setImageResource(R.mipmap.tanchuang_yes);
        } else {
            imageCodeProject.setImageResource(R.mipmap.tanchuang_no);
        }
        if (toast3 == null) {
            toast3 = Toast.makeText(context,
                    text, Toast.LENGTH_SHORT);
            toast3.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast3View.addView(imageCodeProject, 0);//如果不为空，则直接改变当前toast3的文本
        }
        toast3.show();
    }

    // 自定义toast
    public static void customToast(final Context context, final String text, int code) {
        LayoutInflater inflater = LayoutInflater.from(context);

        final View layout = inflater.inflate(R.layout.custom_toast, null);
        imageCodeProject = (ImageView) layout
                .findViewById(R.id.iv_toast);
        if (code == 0) {
            imageCodeProject.setImageResource(R.mipmap.tanchuang_yes);
        } else {
            imageCodeProject.setImageResource(R.mipmap.tanchuang_no);
        }
        TextView content = (TextView) layout.findViewById(R.id.tv_toast);
        content.setText(text);
        ThreadUtils.runOnMainThread(new Runnable() {
            @SuppressLint("WrongConstant")
            @Override
            public void run() {
                if (toast4 == null) {
//                    toast4 = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast4 = new Toast(context);
                    toast4.setView(layout);
                    toast4.setGravity(Gravity.CENTER, 0, 0);
//            toast.setView(layout);
                } else {
                    toast4.setView(layout);//如果不为空，则直接改变当前toast的文本
                }
                toast4.show();
            }
        });

    }
}
