package com.mya.mercadointeligente.mvp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mya.mercadointeligente.R;
import com.mya.mercadointeligente.mvp.MVP;
import com.mya.mercadointeligente.mvp.presenter.PreLoginPresenter;

public class PreLoginActivity extends AppCompatActivity implements MVP.RequiredViewOps{

    private MVP.ProvidedPresenterOps presenter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_login);
        presenter = new PreLoginPresenter(this);
        presenter.onCreate();

    }

    public void nextActivity(Class aClass) {
        this.intent = new Intent(this, aClass);
        this.startActivity(intent);
        finish();
    }

}
