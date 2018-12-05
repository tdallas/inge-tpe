package com.ingeapp.view.fragment;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.CrearPedidoViewModel;
import com.ingeapp.model.viewModel.IngeViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrearPedidoFragment extends IngeFragment {

    private CrearPedidoViewModel crearPedidoViewModel;

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(crearPedidoViewModel));
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_crear_pedido;
    }
}
