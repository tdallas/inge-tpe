package com.ingeapp.view.fragment;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.IngeViewModel;
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
    protected int getViewId() {
        return R.layout.fragment_perfil;
    }
}
