package com.ingeapp.dagger.components;

import android.app.Application;

import com.ingeapp.core.IngeApplication;
import com.ingeapp.dagger.modules.ActivityModule;
import com.ingeapp.dagger.modules.ApplicationModule;
import com.ingeapp.dagger.modules.DataModule;
import com.ingeapp.dagger.modules.FragmentModule;
import com.ingeapp.dagger.modules.ServiceModule;
import com.ingeapp.dagger.modules.ViewModelModule;
import com.ingeapp.model.viewModel.CrearPedidoViewModel;
import com.ingeapp.model.viewModel.DetallePedidoViewModel;
import com.ingeapp.model.viewModel.HomeClienteViewModel;
import com.ingeapp.model.viewModel.HomeRestaurantViewModel;
import com.ingeapp.model.viewModel.LoginViewModel;
import com.ingeapp.model.viewModel.PeddosRestaurantViewModel;
import com.ingeapp.model.viewModel.PedidosClienteViewModel;
import com.ingeapp.model.viewModel.PerfilViewModel;
import com.ingeapp.model.viewModel.UsuariosViewModel;
import com.ingeapp.view.activity.CrearPedidoActivity;
import com.ingeapp.view.activity.DetallePedidoClienteActivity;
import com.ingeapp.view.activity.DetallePedidoRestauranteActivity;
import com.ingeapp.view.activity.HomeClienteActivity;
import com.ingeapp.view.activity.HomeRestaurantActivity;
import com.ingeapp.model.viewModel.SignUpViewModel;
import com.ingeapp.view.activity.LoginActivity;
import com.ingeapp.view.activity.PedidosClientesActivity;
import com.ingeapp.view.activity.PerfilActivity;
import com.ingeapp.view.activity.SignUpActivity;
import com.ingeapp.view.activity.UsuariosActivity;
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

    void inject(HomeClienteViewModel homeClienteViewModel);
    
    void inject(SignUpFragment signUpFragment);

    void inject(SignUpActivity signUpActivity);

    void inject(SignUpViewModel signUpViewModel);

    void inject(HomeRestaurantActivity homeRestaurantActivity);

    void inject(HomeClienteActivity homeClienteActivity);

    void inject(HomeRestaurantViewModel homeRestaurantViewModel);

    void inject(PedidosClienteViewModel pedidosClienteViewModel);

    void inject(PedidosClientesActivity pedidosClientesActivity);

    void inject(PerfilViewModel perfilViewModel);

    void inject(PerfilActivity perfilActivity);

    void inject(CrearPedidoViewModel crearPedidoViewModel);

    void inject(CrearPedidoActivity crearPedidoActivity);

    void inject(UsuariosViewModel usuariosViewModel);

    void inject(UsuariosActivity usuariosActivity);

    void inject(PeddosRestaurantViewModel peddosRestaurantViewModel);

    void inject(DetallePedidoViewModel detallePedidoViewModel);

    void inject(DetallePedidoClienteActivity detallePedidoClienteActivity);

    void inject(DetallePedidoRestauranteActivity detallePedidoRestaurantActivity);

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
