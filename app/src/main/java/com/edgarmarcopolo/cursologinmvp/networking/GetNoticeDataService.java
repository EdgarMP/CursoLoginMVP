package com.edgarmarcopolo.cursologinmvp.networking;

import com.edgarmarcopolo.cursologinmvp.models.NoticeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNoticeDataService {

    @GET("bins/1bsqcn/")
    Call<NoticeList> getNoticeData();


}
