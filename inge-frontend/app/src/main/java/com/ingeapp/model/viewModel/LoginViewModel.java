package com.ingeapp.model.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.db.LoginRepository;
import com.ingeapp.model.request.LoginRequest;
import com.ingeapp.service.payload.UserResponse;

import javax.inject.Inject;

public class LoginViewModel extends IngeViewModel {

    @Inject
    LoginRepository loginRepository;

    @Override
    public void initialize(IngeComponents component) {
        component.inject(this);
    }

    public LiveData<UserResponse> login(String usuario, String clave) {
       return loginRepository.login(new LoginRequest(usuario, clave));
    }
}
