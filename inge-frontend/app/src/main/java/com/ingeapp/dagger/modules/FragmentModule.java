package com.ingeapp.dagger.modules;

import com.ingeapp.view.fragment.CrearPedidoFragment;
import com.ingeapp.view.fragment.DetallePedidoClienteFragment;
import com.ingeapp.view.fragment.HomeClienteFragment;
import com.ingeapp.view.fragment.HomeRestaurantFragment;
import com.ingeapp.view.fragment.LoginFragment;
import com.ingeapp.view.fragment.PedidosClientesFragment;
import com.ingeapp.view.fragment.PerfilFragment;
import com.ingeapp.view.fragment.SignUpFragment;
import com.ingeapp.view.fragment.UsuariosFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    /**
     *
     *
     @ContributesAndroidInjector
     abstract UserProfileFragment contributeUserProfileFragment();
     */

    @ContributesAndroidInjector
    abstract LoginFragment contributeLoginFragment();

    @ContributesAndroidInjector
    abstract HomeClienteFragment contributeHomeClienteFragment();

    @ContributesAndroidInjector
    abstract HomeRestaurantFragment contributeHomeRestaurantFragment();

    @ContributesAndroidInjector
    abstract SignUpFragment contributeSignUpFragment();

    @ContributesAndroidInjector
    abstract PedidosClientesFragment contributePedidosClientesFragment();

    @ContributesAndroidInjector
    abstract PerfilFragment contributesPerfilFragment();

    @ContributesAndroidInjector
    abstract CrearPedidoFragment contributesCrearPedidoFragment();

    @ContributesAndroidInjector
    abstract UsuariosFragment contributesUsuariosFragment();

    @ContributesAndroidInjector
    abstract DetallePedidoClienteFragment contributesDetallePedidoClienteFragment();

}