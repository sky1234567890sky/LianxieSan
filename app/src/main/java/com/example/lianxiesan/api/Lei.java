package com.example.lianxiesan.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 小乐乐 on 2019/6/21.
 */

public interface Lei {
    String url="http://www.qubaobei.com/ios/";
    @GET("cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<FzBean> getData();
}
