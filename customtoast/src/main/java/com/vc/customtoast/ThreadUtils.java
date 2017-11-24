package com.example.vvvvvc.customtoast;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator
 * Time  2017/2/14 11:43
 */

public class ThreadUtils {
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static Executor sExecutor = Executors.newSingleThreadExecutor();

    public static void runOnSubThread(Runnable runnable) {
        sExecutor.execute(runnable);
    }

    //子线程发消息给主线程
    public static void runOnMainThread(Runnable runnable) {
        sHandler.post(runnable);
    }
}
