package com.edgarmarcopolo.cursologinmvp.interfaces;

import com.edgarmarcopolo.cursologinmvp.listeners.OnLoginFinishedListener;

public interface LoginInteractor {

    void validateCredentials(OnLoginFinishedListener listener, String username, String password);
}
