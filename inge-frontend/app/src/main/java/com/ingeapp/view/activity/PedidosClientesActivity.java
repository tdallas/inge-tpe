package com.ingeapp.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.ingeapp.R;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.view.Navigator;

import javax.inject.Inject;

public class PedidosClientesActivity extends IngeActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_blank);
        super.onCreate(savedInstanceState);
        navigator.showPedidosClienteFragment(this);
    }

    @Override
    protected void injectDependencies(IngeComponents portalComponents) {
        portalComponents.inject(this);
    }

    @Override
    public void onBackPressed() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Pref", Context.MODE_PRIVATE);
        if (pref.getBoolean("isCliente", false)) {
            navigator.showHomeClienteActivity(this);
        } else {
            navigator.showHomeRestaurantActivity(this);
        }
    }
}
