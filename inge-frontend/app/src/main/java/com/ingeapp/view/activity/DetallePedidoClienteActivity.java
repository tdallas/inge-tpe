package com.ingeapp.view.activity;

import android.os.Bundle;

import com.ingeapp.R;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.view.Navigator;

import javax.inject.Inject;

public class DetallePedidoClienteActivity extends IngeActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void injectDependencies(IngeComponents ingeComponents) {
        ingeComponents.inject(this);
    }

    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_blank);
        super.onCreate(savedInstanceState);
        navigator.showDetallePedidoClienteFragment(this, getIntent().getLongExtra("idPedido", 0L));
    }

    @Override
    public void onBackPressed() {
        navigator.showPedidosClientesActivity(this, getIntent().getBooleanExtra("isCliente", false));
    }
}
