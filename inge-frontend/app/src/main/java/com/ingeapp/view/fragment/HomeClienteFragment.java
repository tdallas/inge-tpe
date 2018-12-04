package com.ingeapp.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.HomeClienteViewModel;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.LoginViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeClienteFragment extends IngeFragment {

    private HomeClienteViewModel homeClienteViewModel;

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(homeClienteViewModel));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        homeClienteViewModel = ViewModelProviders.of(this).get(HomeClienteViewModel.class);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_cliente_home;
    }

    @OnClick(R.id.crear_pedido)
    public void onCrearPedidoClick() {
        showToastError("onCrearPedidoClick");
    }

    @OnClick(R.id.mis_pedidos)
    public void onMisPedidosClick() {
        showToastError("onMisPedidosClick");
    }

    @OnClick(R.id.mi_perfil)
    public void onMiPerfilClick() {
        showToastError("onPerfilClick");
    }
}
