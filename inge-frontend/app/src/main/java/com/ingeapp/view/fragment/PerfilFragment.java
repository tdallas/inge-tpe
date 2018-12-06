package com.ingeapp.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.LoginViewModel;
import com.ingeapp.model.viewModel.PerfilViewModel;
import com.ingeapp.view.Navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class PerfilFragment extends IngeFragment {

    private PerfilViewModel perfilViewModel;


    @BindView(R.id.emailNuevo)
    EditText email;
    @BindView(R.id.claveNueva)
    EditText clave;
    @BindView(R.id.telefono)
    EditText telefono;
    @BindView(R.id.direccion)
    EditText direccion;
    @BindView(R.id.button_saveChanges)
    RelativeLayout button;
    @BindView(R.id.emailActual)
    EditText emailActual;
    @BindView(R.id.claveActual)
    EditText claveActual;

    @Inject
    Navigator navigator;

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(perfilViewModel));
    }

    @OnClick(R.id.button_saveChanges)
    public void onButtonClick() {
        Long idUser = getContext().getSharedPreferences("Pref", Context.MODE_PRIVATE).getLong("idUser", 0L);
        perfilViewModel.saveChanges(emailActual.getText().toString(), claveActual.getText().toString(),
                email.getText().toString(), clave.getText().toString(),
                telefono.getText().toString(), direccion.getText().toString(), idUser)
                .observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    showToastError("Datos actualizados!");
                    navigator.showHomeClienteActivity(PerfilFragment.this);
                } else {
                    showToastError("Los datos actuales ingresados son invalidos!");
                }
            }
        });
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
