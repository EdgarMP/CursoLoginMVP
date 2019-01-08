package com.edgarmarcopolo.cursologinmvp.interfaces;

import com.edgarmarcopolo.cursologinmvp.models.Notice;

import java.util.ArrayList;

public interface ListView {

    void showProgress();
    void hideProgress();
    void requestCompleted(ArrayList<Notice> arrayList);
    void requestFailed();

}
