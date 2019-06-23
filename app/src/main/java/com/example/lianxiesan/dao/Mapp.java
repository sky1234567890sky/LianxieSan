package com.example.lianxiesan.dao;

import android.app.Application;

/**
 * Created by 小乐乐 on 2019/6/23.
 */

public class Mapp extends Application{
    private static Mapp mMapp;

    @Override
    public void onCreate() {
        super.onCreate();
        mMapp=this;
    }

    public static Mapp getMapp() {
        return mMapp;
    }
}
