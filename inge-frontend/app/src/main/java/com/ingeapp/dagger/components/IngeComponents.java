package com.ingeapp.dagger.components;

import android.app.Application;

import com.ingeapp.core.IngeApplication;
import com.ingeapp.dagger.modules.ActivityModule;
import com.ingeapp.dagger.modules.ApplicationModule;
import com.ingeapp.dagger.modules.DataModule;
import com.ingeapp.dagger.modules.FragmentModule;
import com.ingeapp.dagger.modules.ServiceModule;
import com.ingeapp.dagger.modules.ViewModelModule;
import com.ingeapp.model.viewModel.LoginViewModel;
import com.ingeapp.model.viewModel.SignUpViewModel;
import com.ingeapp.view.activity.LoginActivity;
import com.ingeapp.view.activity.SignUpActivity;
import com.ingeapp.view.fragment.LoginFragment;
import com.ingeapp.view.fragment.SignUpFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                ServiceModule.class,
                DataModule.class,
                ApplicationModule.class,
                ActivityModule.class,
                FragmentModule.class,

        }
)
public interface IngeComponents {
    void inject(IngeApplication ingeApplication);

    void inject(LoginFragment loginFragment);

    void inject(LoginActivity loginActivity);

    void inject(LoginViewModel loginViewModel);

    void inject(SignUpFragment signUpFragment);

    void inject(SignUpActivity signUpActivity);

    void inject(SignUpViewModel signUpViewModel);

    final class Initializer {
        public static IngeComponents init(ApplicationModule applicationModule,
                                           ServiceModule serviceModule,
                                           DataModule dataModule) {
            return DaggerIngeComponents
                    .builder()
                    .applicationModule(applicationModule)
                    .dataModule(dataModule)
                    .serviceModule(serviceModule)
                    .build();
        }
    }


}
