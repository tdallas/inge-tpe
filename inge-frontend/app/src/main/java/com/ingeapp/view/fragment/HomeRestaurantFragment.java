package com.ingeapp.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.HomeRestaurantViewModel;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.view.Navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.OnClick;

public class HomeRestaurantFragment extends IngeFragment {

    @Inject
    Navigator navigator;

    private HomeRestaurantViewModel homeRestaurantViewModel;

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(homeRestaurantViewModel));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        homeRestaurantViewModel = ViewModelProviders.of(this).get(HomeRestaurantViewModel.class);
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.verPedidos)
    public void onVerPedidosClick() {
        navigator.showPedidosClientesActivity(this);
    }

    @OnClick(R.id.verUsuarios)
    public void onVerUsuariosClick() {
        navigator.showVerUsuariosActivity(this);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_restaurant_home;
    }
}
