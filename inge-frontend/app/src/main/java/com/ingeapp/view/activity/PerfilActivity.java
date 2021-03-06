package com.ingeapp.view.activity;

import android.os.Bundle;

import com.ingeapp.R;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.view.Navigator;

import javax.inject.Inject;

public class PerfilActivity extends IngeActivity {

    //fixme aca va a haber un boton para hacer logout, hay que borrar el usuario de la base

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_blank);
        super.onCreate(savedInstanceState);
        navigator.showPerfilFragment(this);
    }

    @Override
    protected void injectDependencies(IngeComponents ingeComponents) {
        ingeComponents.inject(this);
    }

    @Override
    public void onBackPressed() {
        navigator.showHomeClienteActivity(this);
    }
}
