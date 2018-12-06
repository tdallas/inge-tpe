package com.ingeapp.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ingeapp.R;
import com.ingeapp.model.entities.Pedido;
import com.ingeapp.model.entities.Producto;
import com.ingeapp.model.viewModel.DetallePedidoRestauranteViewModel;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.util.DetalleProductoAdapter;
import com.ingeapp.view.Navigator;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class DetallePedidoRestauranteFragment extends IngeFragment {

    @Inject
    Navigator navigator;

    @BindView(R.id.estado)
    TextView estado;
    @BindView(R.id.direccion)
    TextView direccion;
    @BindView(R.id.telefono)
    TextView telefono;
    @BindView(R.id.nombre)
    TextView nombre;
    @BindView(R.id.apellido)
    TextView apellido;
    @BindView(R.id.precio)
    TextView precio;
    @BindView(R.id.button_cambiar_estado)
    RelativeLayout cambiarEstado;
    @BindView(R.id.recycler_productos)
    RecyclerView productos;

    DetalleProductoAdapter detalleProductoAdapter = new DetalleProductoAdapter();

    DetallePedidoRestauranteViewModel detallePedidoRestauranteViewModel;

    private long idPedido;

    public static Fragment newInstance(long idPedido) {
        DetallePedidoRestauranteFragment fragment = new DetallePedidoRestauranteFragment();
        fragment.setIdPedido(idPedido);
        return fragment;
    }

    private void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        productos.setLayoutManager(new LinearLayoutManager(getContext()));
        productos.setAdapter(detalleProductoAdapter);
    }

    public void onCreate(Bundle savedInstanceState) {
        detallePedidoRestauranteViewModel = ViewModelProviders.
                of(this).get(DetallePedidoRestauranteViewModel.class);
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        detallePedidoRestauranteViewModel.getPedido(idPedido).observe(this, new Observer<Pedido>() {
            @Override
            public void onChanged(@Nullable Pedido pedido) {
                if (pedido != null) {
                    List<Producto> productos = new ArrayList<>();
                    for (Producto p : pedido.getProductos()) {
                        if (p.getCantidad() != 0)
                            productos.add(p);
                    }
                    detalleProductoAdapter.setList(productos);
                    detalleProductoAdapter.notifyDataSetChanged();
                    nombre.setText(pedido.getCliente().getNombre());
                    apellido.setText(pedido.getCliente().getApellido());
                    estado.setText(pedido.getEstado());
                    direccion.setText(pedido.getDireccionEntrega());
                    telefono.setText(pedido.getCliente().getTelefono());
                    precio.setText("$" + pedido.getPrecio());
                }
            }
        });
    }

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singleton(detallePedidoRestauranteViewModel));
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_detalles_pedido_restaurante;
    }
}
