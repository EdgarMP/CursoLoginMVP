package com.edgarmarcopolo.cursologinmvp.interfaces;

import com.edgarmarcopolo.cursologinmvp.listeners.OnListDownloadedListener;

public interface ListInteractor {

    void getList(OnListDownloadedListener listDownloadedListener);
}
