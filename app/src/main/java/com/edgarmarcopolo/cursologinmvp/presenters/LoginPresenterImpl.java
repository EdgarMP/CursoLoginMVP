package com.edgarmarcopolo.cursologinmvp.presenters;

import com.edgarmarcopolo.cursologinmvp.interactors.LoginInteractorImpl;
import com.edgarmarcopolo.cursologinmvp.interfaces.LoginInteractor;
import com.edgarmarcopolo.cursologinmvp.interfaces.LoginPresenter;
import com.edgarmarcopolo.cursologinmvp.interfaces.LoginView;
import com.edgarmarcopolo.cursologinmvp.listeners.OnLoginFinishedListener;

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view){
        this.view = view;
        interactor = new LoginInteractorImpl();
    }

    @Override
    public void attemptLogin(String username, String password) {
        if(view!=null){
            view.showProgress();
            interactor.validateCredentials(this, username, password);
        }

    }

    @Override
    public void onError() {
        if(view!=null){
            view.hideProgress();
            view.accessDenied();
        }

    }

    @Override
    public void onSuccess() {
        if(view!=null){
            view.hideProgress();
            view.accessSuccessful();
        }
    }
}
