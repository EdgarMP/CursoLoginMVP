package com.edgarmarcopolo.cursologinmvp.listeners;

import com.edgarmarcopolo.cursologinmvp.models.Notice;

import java.util.ArrayList;

public interface OnListDownloadedListener {
    void onFinished(ArrayList<Notice> arrayList);
    void onError();
}
