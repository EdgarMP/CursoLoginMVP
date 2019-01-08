package com.edgarmarcopolo.cursologinmvp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.edgarmarcopolo.cursologinmvp.R;
import com.edgarmarcopolo.cursologinmvp.interfaces.LoginPresenter;
import com.edgarmarcopolo.cursologinmvp.interfaces.LoginView;
import com.edgarmarcopolo.cursologinmvp.presenters.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText username, password;
    private ProgressBar progressBar;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressbar);
        presenter = new LoginPresenterImpl(this);
    }

    //Onclick desde el XML
    public void login(View view) {
        //presenter.attemptLogin(username.getText().toString(), password.getText().toString());
        startActivity(new Intent(this, ListActivity.class));
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void accessSuccessful() {
        Toast.makeText(this, "Acceso OK", Toast.LENGTH_LONG).show();
    }

    @Override
    public void accessDenied() {
        Toast.makeText(this, "Acceso MALO", Toast.LENGTH_LONG).show();
    }
}
