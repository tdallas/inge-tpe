package com.ingeapp.model.viewModel;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.db.LoginRepository;

import javax.inject.Inject;

public class LoginViewModel extends IngeViewModel {

    @Inject
    LoginRepository loginRepository;

    @Override
    public void initialize(IngeComponents component) {

    }
}
