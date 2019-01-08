package com.edgarmarcopolo.cursologinmvp.presenters;

import com.edgarmarcopolo.cursologinmvp.interactors.ListInteractorImpl;
import com.edgarmarcopolo.cursologinmvp.interfaces.ListInteractor;
import com.edgarmarcopolo.cursologinmvp.interfaces.ListPresenter;
import com.edgarmarcopolo.cursologinmvp.interfaces.ListView;
import com.edgarmarcopolo.cursologinmvp.listeners.OnListDownloadedListener;
import com.edgarmarcopolo.cursologinmvp.models.Notice;

import java.util.ArrayList;

public class ListPresenterImpl implements ListPresenter, OnListDownloadedListener {


    private ListView mListView;
    private ListInteractor mListInteractor;

    public ListPresenterImpl(ListView listView){
        this.mListView = listView;
        mListInteractor = new ListInteractorImpl();

    }

    @Override
    public void attemptRetrieveList() {
        mListView.showProgress();
        mListInteractor.getList(this);
    }

    @Override
    public void onFinished(ArrayList<Notice> arrayList) {
        mListView.hideProgress();
        mListView.requestCompleted(arrayList);

    }

    @Override
    public void onError() {
        mListView.requestFailed();
        mListView.hideProgress();
    }
}
