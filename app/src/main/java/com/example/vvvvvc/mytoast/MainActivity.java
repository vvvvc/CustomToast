package com.example.vvvvvc.mytoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.vvvvvc.customtoast.ToastUtil;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtil.customToast(this, "访问成功", 1);
    }
}
