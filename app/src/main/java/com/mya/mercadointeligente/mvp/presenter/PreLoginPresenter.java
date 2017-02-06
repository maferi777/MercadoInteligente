package com.mya.mercadointeligente.mvp.presenter;

import android.content.Context;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mya.mercadointeligente.mvp.MVP;
import com.mya.mercadointeligente.mvp.view.FoodsListActivity;
import com.mya.mercadointeligente.mvp.view.LoginActivity;

/**
 * Created by msanchez on 2/6/2017.
 */

public class PreLoginPresenter implements MVP.ProvidedPresenterOps,MVP.RequiredPresenterOps {

    private FirebaseUser user;
    private Intent intent;
    private MVP.RequiredViewOps view;

    public PreLoginPresenter(MVP.RequiredViewOps view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        if(isLogin()){
            view.nextActivity(FoodsListActivity.class);
        }else {
            view.nextActivity(LoginActivity.class);
        }
    }

    public boolean isLogin(){
        this.user =  FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}
