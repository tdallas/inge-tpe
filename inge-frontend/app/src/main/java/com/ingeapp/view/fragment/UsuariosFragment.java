package com.ingeapp.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.UsuariosViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuariosFragment extends IngeFragment {

    UsuariosViewModel usuariosViewModel;

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(usuariosViewModel));
    }

    public void onCreate(Bundle savedInstanceState) {
        usuariosViewModel = ViewModelProviders.of(this).get(UsuariosViewModel.class);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_ver_usuarios;
    }
}
