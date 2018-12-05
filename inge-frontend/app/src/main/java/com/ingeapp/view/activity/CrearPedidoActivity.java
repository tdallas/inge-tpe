package com.ingeapp.view.activity;

import android.os.Bundle;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.view.Navigator;

import javax.inject.Inject;

public class CrearPedidoActivity extends IngeActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void injectDependencies(IngeComponents ingeComponents) {
        ingeComponents.inject(this);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigator.showCrearPedidoFragment(this);
    }
}
