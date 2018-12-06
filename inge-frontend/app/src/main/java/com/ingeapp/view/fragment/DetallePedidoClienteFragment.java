package com.ingeapp.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ingeapp.R;
import com.ingeapp.model.entities.Pedido;
import com.ingeapp.model.viewModel.DetallePedidoViewModel;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.view.Navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class DetallePedidoClienteFragment extends IngeFragment {

    DetallePedidoViewModel detallePedidoViewModel;

    @Inject
    Navigator navigator;

    private long idPedido;
    private String calificacion = "";

    @BindView(R.id.estado)
    TextView estado;
    @BindView(R.id.precio)
    TextView precio;
    @BindView(R.id.buena_checkbox)
    CheckBox buena;
    @BindView(R.id.mala_checkbox)
    CheckBox mala;
    @BindView(R.id.muybuena_checkbox)
    CheckBox muyBuena;
    @BindView(R.id.normal_checkbox)
    CheckBox normal;
    @BindView(R.id.regular_checkbox)
    CheckBox regular;

    @OnCheckedChanged(R.id.mala_checkbox)
    public void onMalaCheck() {
        if (!mala.isChecked())
            return;
        mala.setChecked(true);
        buena.setChecked(false);
        muyBuena.setChecked(false);
        normal.setChecked(false);
        regular.setChecked(false);
        calificacion = "Mala";
    }

    @OnCheckedChanged(R.id.regular_checkbox)
    public void onRegularChecked() {
        if (!regular.isChecked())
            return;
        mala.setChecked(false);
        buena.setChecked(false);
        muyBuena.setChecked(false);
        normal.setChecked(false);
        regular.setChecked(true);
        calificacion = "Regular";
    }

    @OnCheckedChanged(R.id.normal_checkbox)
    public void onNormalChecked() {
        if (!normal.isChecked())
            return;
        mala.setChecked(false);
        buena.setChecked(false);
        muyBuena.setChecked(false);
        normal.setChecked(true);
        regular.setChecked(false);
        calificacion = "Normal";
    }

    @OnCheckedChanged(R.id.buena_checkbox)
    public void onBuenaChecked() {
        if (!buena.isChecked())
            return;
        mala.setChecked(false);
        buena.setChecked(true);
        muyBuena.setChecked(false);
        normal.setChecked(false);
        regular.setChecked(false);
        calificacion = "Buena";
    }

    @OnCheckedChanged(R.id.muybuena_checkbox)
    public void onMuyBuenaChecked() {
        if (!muyBuena.isChecked())
            return;
        mala.setChecked(false);
        buena.setChecked(false);
        muyBuena.setChecked(true);
        normal.setChecked(false);
        regular.setChecked(false);
        calificacion = "Muy buena";
    }

    @OnClick(R.id.button_calificar)
    public void onCalificarClick() {
        detallePedidoViewModel.calificar(calificacion, idPedido).observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    showToastError("Calificaste tu pedido!");
                    navigator.showHomeClienteActivity(DetallePedidoClienteFragment.this);
                } else {
                    showToastError("Ocurrio un error de conexión");
                }
            }
        });
    }

    public static Fragment newInstance(long idPedido) {
        DetallePedidoClienteFragment fragment = new DetallePedidoClienteFragment();
        fragment.setIdPedido(idPedido);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        detallePedidoViewModel = ViewModelProviders.of(this).get(DetallePedidoViewModel.class);
        super.onCreate(savedInstanceState);
    }

    private void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public void onResume() {
        super.onResume();
        detallePedidoViewModel.getPedido(idPedido).observe(this, new Observer<Pedido>() {
            @Override
            public void onChanged(@Nullable Pedido pedido) {
                if (pedido == null) {
                    showToastError("Hubo un error de conexión");
                } else {
                    precio.setText("$" + pedido.getPrecio());
                    estado.setText(pedido.getEstado());
                }
            }
        });
    }

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singleton(detallePedidoViewModel));
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_detalles_pedido_cliente;
    }
}
