package com.ingeapp.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.ingeapp.R;
import com.ingeapp.model.entities.Pedido;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.PeddosRestaurantViewModel;
import com.ingeapp.model.viewModel.PedidosClienteViewModel;
import com.ingeapp.util.PedidosAdapter;
import com.ingeapp.view.fragmentView.ClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class PedidosClientesFragment extends IngeFragment implements ClickListener {

    private PedidosClienteViewModel pedidosClienteViewModel;
    private PeddosRestaurantViewModel pedidosRestaurantViewModel;

    private PedidosAdapter pedidosAdapter = new PedidosAdapter(this);


    @BindView(R.id.recycler_pedidos)
    RecyclerView pedidos;

    @Override
    protected List<IngeViewModel> getViewModels() {
        List<IngeViewModel> viewModels = new ArrayList<>();
        viewModels.add(pedidosClienteViewModel);
        viewModels.add(pedidosRestaurantViewModel);
        return new ArrayList<IngeViewModel>(viewModels);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_ver_pedidos;
    }

    public void onCreate(Bundle savedInstanceState) {
        pedidosRestaurantViewModel = ViewModelProviders.of(this).get(PeddosRestaurantViewModel.class);
        pedidosClienteViewModel = ViewModelProviders.of(this).get(PedidosClienteViewModel.class);
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        boolean isCliente = getActivity().getIntent().getBooleanExtra("isCliente", false);
        if (isCliente) {

        } else {
            pedidosRestaurantViewModel.getAllPedidos().observe(this, new Observer<List<Pedido>>() {
                @Override
                public void onChanged(@Nullable List<Pedido> pedidos) {
                    pedidosAdapter.setList(pedidos);
                    pedidosAdapter.notifyDataSetChanged();
                }
            });
        }
    }

   // @Override
    public void showFoto(String path) {
        PhotoPreview photoPreview = PhotoPreview.newInstance();
        photoPreview.setPath(path);
        photoPreview.show(getChildFragmentManager(), "Dialog");
    }

    @Override
    public void onClick(Long idItemClicked) {
        //todo
    }
}
