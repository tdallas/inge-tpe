package com.ingeapp.model.viewModel;

import com.ingeapp.dagger.components.IngeComponents;

public class PedidosClienteViewModel extends IngeViewModel {
    @Override
    public void initialize(IngeComponents component) {
        component.inject(this);
    }
}
