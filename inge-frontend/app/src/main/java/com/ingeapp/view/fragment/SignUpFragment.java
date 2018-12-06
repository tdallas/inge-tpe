package com.ingeapp.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.LoginViewModel;
import com.ingeapp.model.viewModel.SignUpViewModel;
import com.ingeapp.view.Navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpFragment extends IngeFragment {


    @Inject
    Navigator navigator;

    @BindView(R.id.email)
    EditText emailInput;

    @BindView(R.id.clave)
    EditText claveInput;

    @BindView(R.id.dni)
    EditText dniInput;

    @BindView(R.id.telefono)
    EditText telefonoInput;

    @BindView(R.id.nombre)
    EditText nombreInput;

    @BindView(R.id.apellido)
    EditText apellidoInput;

    @BindView(R.id.direccion)
    EditText direccion;

    @BindView(R.id.button_signup)
    RelativeLayout signUpButton;

    SignUpViewModel signUpViewModel;

    @Override
    protected int getViewId() {
        return R.layout.fragment_signup;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(signUpViewModel));
    }

    @OnClick(R.id.button_signup)
    public void onSignUpAttempt() {
        signUpViewModel.signUp(emailInput.getText().toString(),
                claveInput.getText().toString(), dniInput.getText().toString(),
                telefonoInput.getText().toString(), nombreInput.getText().toString(),
                apellidoInput.getText().toString(), direccion.getText().toString()).observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean != null && aBoolean) {
                    navigator.showLoginActivity(SignUpFragment.this);
                    showToastError("Usuario creado exitosamente!");
                } else if (aBoolean != null && !aBoolean) {
                    showToastError("ERROR: Usuario no creado!");
                }
            }
        });
    }

}
