package com.ingeapp.view.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.PedidosClienteViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class PedidosClientesFragment extends IngeFragment {

    private PedidosClienteViewModel pedidosClienteViewModel;

    @BindView(R.id.recycler_pedidos)
    RecyclerView pedidos;

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(pedidosClienteViewModel));
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_ver_pedidos;
    }

    public void onCreate(Bundle savedInstanceState) {
        pedidosClienteViewModel = ViewModelProviders.of(this).get(PedidosClienteViewModel.class);
        super.onCreate(savedInstanceState);
    }

   // @Override
    public void showFoto(String path) {
        PhotoPreview photoPreview = PhotoPreview.newInstance();
        photoPreview.setPath(path);
        photoPreview.show(getChildFragmentManager(), "Dialog");
    }
}
