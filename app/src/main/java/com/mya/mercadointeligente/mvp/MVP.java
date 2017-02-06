package com.mya.mercadointeligente.mvp;

/**
 * Created by msanchez on 2/6/2017.
 */

public interface MVP {

    public interface RequiredViewOps {
        void nextActivity(Class aClass);
    };

    public interface ProvidedPresenterOps {
        void onCreate();
        boolean isLogin();
    };

    public interface RequiredPresenterOps{

    };

    public interface ProvidedModelOps{

    };
}
