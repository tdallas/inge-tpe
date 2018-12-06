package com.ingeapp.view.activity;

import android.os.Bundle;

import com.ingeapp.R;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.view.Navigator;

import javax.inject.Inject;

public class HomeClienteActivity extends IngeActivity {

    @Inject
    Navigator navigator;

    private boolean close = false;

    @Override
    protected void injectDependencies(IngeComponents ingeComponents) {
        ingeComponents.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_blank);
        super.onCreate(savedInstanceState);
        navigator.showHomeClienteFragment(this);
    }

    public void onBackPressed() {
        if (!close) {
            showToastError("Presione nuevamente para salir de la app");
            close = true;
        } else {
            finishAffinity();
        }
    }
}
