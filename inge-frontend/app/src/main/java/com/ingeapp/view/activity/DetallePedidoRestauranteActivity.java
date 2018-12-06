package com.ingeapp.view.activity;

import com.ingeapp.dagger.components.IngeComponents;

public class DetallePedidoRestauranteActivity extends IngeActivity {
    @Override
    protected void injectDependencies(IngeComponents ingeComponents) {
        ingeComponents.inject(this);
    }
}
