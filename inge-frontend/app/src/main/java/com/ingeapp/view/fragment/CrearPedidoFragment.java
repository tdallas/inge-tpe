package com.ingeapp.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ingeapp.R;
import com.ingeapp.model.entities.Producto;
import com.ingeapp.model.viewModel.CrearPedidoViewModel;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.util.ProductosAdapter;
import com.ingeapp.view.fragmentView.Calculator;
import com.ingeapp.view.fragmentView.ClickListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class CrearPedidoFragment extends IngeFragment implements Calculator {

    private CrearPedidoViewModel crearPedidoViewModel;

    @BindView(R.id.recylcer_productos)
    RecyclerView recyclerView;
    @BindView(R.id.total_gastado)
    TextView total;

    private ProductosAdapter adapter;

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(crearPedidoViewModel));
    }

    public void onCreate(Bundle savedInstanceState) {
        crearPedidoViewModel = ViewModelProviders.of(this).get(CrearPedidoViewModel.class);
        super.onCreate(savedInstanceState);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ProductosAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    public void onResume() {
        super.onResume();
        crearPedidoViewModel.getAllProductos().observe(this, new Observer<List<Producto>>() {
            @Override
            public void onChanged(@Nullable List<Producto> productos) {
                adapter.setList(productos);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_crear_pedido;
    }

    @Override
    public void calcularTotal() {
        Double suma = 0D;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (Producto p : adapter.getProductos()) {
            suma += p.getPrecio() * p.getCantidad();
        }
        total.setText("$" + decimalFormat.format(suma).toString());
    }
}
