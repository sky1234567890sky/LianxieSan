package com.example.lianxiesan.api;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 小乐乐 on 2019/6/23.
 */
@Entity
public class SjBean {
    @Id(autoincrement = true)
    private Long id;
    private String food_str;
    @Generated(hash = 5976115)
    public SjBean(Long id, String food_str) {
        this.id = id;
        this.food_str = food_str;
    }
    @Generated(hash = 1815906733)
    public SjBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFood_str() {
        return this.food_str;
    }
    public void setFood_str(String food_str) {
        this.food_str = food_str;
    }

}
