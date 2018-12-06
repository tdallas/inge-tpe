package com.ingeapp.model.viewModel;

import android.arch.lifecycle.LiveData;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.db.SignUpRepository;
import com.ingeapp.model.request.SignUpRequest;

import javax.inject.Inject;

public class SignUpViewModel extends IngeViewModel {

    @Inject
    SignUpRepository signUpRepository;

    @Override
    public void initialize(IngeComponents component) {
        component.inject(this);
    }

    public LiveData<Boolean> signUp(String email, String clave, String dni,
                                    String telefono, String nombre, String apellido, String direccion) {
        return signUpRepository.signUp(new SignUpRequest(email, clave, dni, telefono, nombre, apellido, direccion));
    }
}
