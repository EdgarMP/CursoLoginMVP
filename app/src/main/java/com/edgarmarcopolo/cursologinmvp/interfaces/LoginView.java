package com.edgarmarcopolo.cursologinmvp.interfaces;

public interface LoginView  {

    void showProgress();
    void hideProgress();
    void accessSuccessful();
    void accessDenied();

}
