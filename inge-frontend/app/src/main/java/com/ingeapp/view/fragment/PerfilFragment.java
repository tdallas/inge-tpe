package com.ingeapp.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.LoginViewModel;
import com.ingeapp.model.viewModel.PerfilViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerfilFragment extends IngeFragment {

    private PerfilViewModel perfilViewModel;

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(perfilViewModel));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        perfilViewModel = ViewModelProviders.of(this).get(PerfilViewModel.class);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_perfil;
    }
}
