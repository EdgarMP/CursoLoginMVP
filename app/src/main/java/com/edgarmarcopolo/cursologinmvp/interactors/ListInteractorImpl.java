package com.edgarmarcopolo.cursologinmvp.interactors;

import android.util.Log;

import com.edgarmarcopolo.cursologinmvp.interfaces.ListInteractor;
import com.edgarmarcopolo.cursologinmvp.listeners.OnListDownloadedListener;
import com.edgarmarcopolo.cursologinmvp.models.NoticeList;
import com.edgarmarcopolo.cursologinmvp.networking.GetNoticeDataService;
import com.edgarmarcopolo.cursologinmvp.networking.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListInteractorImpl implements ListInteractor {

    @Override
    public void getList(final OnListDownloadedListener listDownloadedListener) {

        /** Create handle for the RetrofitInstance interface*/
        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<NoticeList> call = service.getNoticeData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                //onFinishedListener.onFinished(response.body().getNoticeArrayList());
                listDownloadedListener.onFinished(response.body().getNoticeArrayList());

            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                //onFinishedListener.onFailure(t);
                listDownloadedListener.onError();
            }
        });

    }
}
