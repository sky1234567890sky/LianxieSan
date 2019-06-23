package com.example.lianxiesan.dao;

import com.example.lianxiesan.api.SjBean;
import com.example.lizhengjun.dao.DaoMaster;
import com.example.lizhengjun.dao.DaoSession;
import com.example.lizhengjun.dao.SjBeanDao;

import java.util.List;

/**
 * Created by 小乐乐 on 2019/6/23.
 */

public class DaoUtil {
    private static DaoUtil daoUtil;
    private final SjBeanDao mSjBeanDao;


    public DaoUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Mapp.getMapp(), "hah.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mSjBeanDao = daoSession.getSjBeanDao();
    }

    public static DaoUtil getDaoUtil() {
        if (daoUtil==null){
            synchronized (DaoUtil.class){
                if (daoUtil==null){
                    daoUtil=new DaoUtil();
                }
            }
        }
        return daoUtil;
    }

    public void insertItem(SjBean sjBean){
         mSjBeanDao.insertOrReplace(sjBean);
    }
    public List<SjBean> LoallAll(){
        return mSjBeanDao.loadAll();
    }
    public void deleteItem(SjBean sjBean){
        mSjBeanDao.delete(sjBean);
    }
}
