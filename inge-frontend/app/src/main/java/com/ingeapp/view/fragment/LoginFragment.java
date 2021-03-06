package com.ingeapp.view.fragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ingeapp.R;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.LoginViewModel;
import com.ingeapp.service.payload.UserResponse;
import com.ingeapp.view.Navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends IngeFragment {

    @Inject
    Navigator navigator;

    @BindView(R.id.usuario)
    EditText usuarioInput;

    @BindView(R.id.clave)
    EditText claveInput;

    @BindView(R.id.button_login)
    RelativeLayout loginButton;

    @BindView(R.id.button_signup)
    RelativeLayout signUpButton;

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
        final LiveData<UserResponse> observer = loginViewModel.login(usuarioInput.getText().toString(),
                claveInput.getText().toString());
        observer.observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(@Nullable UserResponse response) {
                //fixme nefasto
                if (response != null && response.getLogged()) {
                    observer.removeObservers(LoginFragment.this);
                    if (response.getRol().equals("CLIENTE")) {
                        navigator.showHomeClienteActivity(LoginFragment.this);
                    } else {
                        navigator.showHomeRestaurantActivity(LoginFragment.this);
                    }
                } else {
                    showToastError("ERROR EN EL LOGIN");
                }
            }
        });
    }

    @OnClick(R.id.button_signup)
    public void onSingUpAttempt() {
        navigator.showSignUpActivity(this);
    }

}
