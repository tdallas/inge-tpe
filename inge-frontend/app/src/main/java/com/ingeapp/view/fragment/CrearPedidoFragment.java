package com.ingeapp.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

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

    public void onCreate(Bundle savedInstanceState) {
        crearPedidoViewModel = ViewModelProviders.of(this).get(CrearPedidoViewModel.class);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_crear_pedido;
    }
}
