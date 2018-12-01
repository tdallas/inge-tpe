package com.ingeapp.view.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.ingeapp.R;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.LoginViewModel;
import com.ingeapp.view.Navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginFragment extends IngeFragment {

    @Inject
    Navigator navigator;

    @BindView(R.id.usuario)
    EditText usuarioInput;

    @BindView(R.id.clave)
    EditText claveInput;

    @BindView(R.id.button_login)
    RelativeLayout button;

    LoginViewModel loginViewModel;

    @Override
    protected int getViewId() {
        return R.layout.fragment_login;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(loginViewModel));
    }

    @OnClick(R.id.button_login)
    public void onLogginAttempt() {
        showToastError("USUARIO " + usuarioInput.getText() + " CLAVE " + claveInput.getText());
    }

}
