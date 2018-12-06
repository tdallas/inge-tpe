package com.ingeapp.view;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.ingeapp.R;
import com.ingeapp.view.activity.CrearPedidoActivity;
import com.ingeapp.view.activity.DetallePedidoClienteActivity;
import com.ingeapp.view.activity.DetallePedidoRestauranteActivity;
import com.ingeapp.view.activity.HomeClienteActivity;
import com.ingeapp.view.activity.HomeRestaurantActivity;
import com.ingeapp.view.activity.IngeActivity;
import com.ingeapp.view.activity.LoginActivity;
import com.ingeapp.view.activity.PedidosClientesActivity;
import com.ingeapp.view.activity.PerfilActivity;
import com.ingeapp.view.activity.UsuariosActivity;
import com.ingeapp.view.fragment.CrearPedidoFragment;
import com.ingeapp.view.fragment.DetallePedidoClienteFragment;
import com.ingeapp.view.fragment.DetallePedidoRestauranteFragment;
import com.ingeapp.view.fragment.HomeClienteFragment;
import com.ingeapp.view.fragment.HomeRestaurantFragment;
import com.ingeapp.view.activity.SignUpActivity;
import com.ingeapp.view.fragment.LoginFragment;
import com.ingeapp.view.fragment.PedidosClientesFragment;
import com.ingeapp.view.fragment.PerfilFragment;
import com.ingeapp.view.fragment.SignUpFragment;
import com.ingeapp.view.fragment.UsuariosFragment;

/**
 * this class is use to navigate between activities and fragments
 */
public class Navigator {

    public Navigator() {

    }

    /**
     * Activities
     * public ..(Activity from, params)
     * Intent intent = new Intent(from.getApplicationContext(), MyClassActivity.class);
     * intent = MyClassActivity.putParams(*);
     * from.startActivity(intent);
     */


    public void showHomeClienteActivity(LoginFragment loginFragment) {
        Intent intent = new Intent(loginFragment.getContext(), HomeClienteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        loginFragment.startActivity(intent);
    }

    public void showLoginActivity(HomeClienteActivity homeClienteActivity) {
        Intent intent = new Intent(homeClienteActivity.getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        homeClienteActivity.startActivity(intent);
    }


    /**
     * Fragments
     * <p>
     * function declaration(params)
     * openFragment(ActivityFrom, fragment, fragment name, addToBackStack?
     */

    public void showSignUpActivity(LoginFragment from) {
        Intent intent = new Intent(from.getContext(), SignUpActivity.class);
        from.startActivity(intent);
    }

    public void showHomeRestaurantActivity(LoginFragment loginFragment) {
        Intent intent = new Intent(loginFragment.getContext(), HomeRestaurantActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        loginFragment.startActivity(intent);
    }

    public void showLoginFragment(LoginActivity loginActivity) {
        openFragment(loginActivity, new LoginFragment(), "LoginFragment", false);
    }

    public void showSignUpFragment(SignUpActivity signUpActivity) {
        openFragment(signUpActivity, new SignUpFragment(), "SignUpFragment", false);
    }

    public void showHomeClienteFragment(HomeClienteActivity homeClienteActivity) {
        openFragment(homeClienteActivity, new HomeClienteFragment(),
                "HomeClienteFragment", false);
    }


    public void showLoginActivity(SignUpFragment from) {
        Intent intent = new Intent(from.getContext(), LoginActivity.class);
        from.startActivity(intent);
    }

    public void showHomeRestaurantFragment(HomeRestaurantActivity homeRestaurantActivity) {
        openFragment(homeRestaurantActivity, new HomeRestaurantFragment(),
                "HomeRestaurantFragment", false);
    }

    public void showPedidosClienteFragment(PedidosClientesActivity pedidosClientesActivity) {
        openFragment(pedidosClientesActivity, new PedidosClientesFragment(),
                "PedidosClientes", false);
    }

    public void showPerfilFragment(PerfilActivity perfilActivity) {
        openFragment(perfilActivity, new PerfilFragment(), "Perfil", false);
    }


    public void showCrearPedidoFragment(CrearPedidoActivity crearPedidoActivity) {
        openFragment(crearPedidoActivity,new CrearPedidoFragment(), "Crea tu pedido", false);
    }


    private Fragment openFragment(IngeActivity from, Fragment fragment, String name, boolean addToBackStack) {
        FragmentTransaction transaction = from.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content_frame, fragment, name);
        if (addToBackStack)
            transaction.addToBackStack(name);
        from.setTitle(name);
        transaction.commit();
        from.invalidateOptionsMenu();
        return fragment;
    }

    public void showCrearPedidoActivity(HomeClienteFragment from) {
        Intent intent = new Intent(from.getContext(), CrearPedidoActivity.class);
        from.startActivity(intent);
    }

    public void showMisPedidosActiivty(HomeClienteFragment from) {
        Intent intent = new Intent(from.getContext(), PedidosClientesActivity.class);
        intent.putExtra("isCliente", true);
        from.startActivity(intent);
    }

    public void showMiPerfilActivity(HomeClienteFragment from) {
        Intent intent = new Intent(from.getContext(), PerfilActivity.class);
        from.startActivity(intent);
    }

    public void showPedidosClientesActivity(HomeRestaurantFragment from) {
        Intent intent = new Intent(from.getContext(), PedidosClientesActivity.class);
        from.startActivity(intent);
    }

    public void showVerUsuariosActivity(HomeRestaurantFragment from) {
        Intent intent = new Intent(from.getContext(), UsuariosActivity.class);
        from.startActivity(intent);
    }

    public void showVerUsuariosFragment(UsuariosActivity usuariosActivity) {
        openFragment(usuariosActivity, new UsuariosFragment(), "Ver usuarios", false);
    }

    public void showHomeClienteActivity(CrearPedidoFragment crearPedidoFragment) {
        Intent intent = new Intent(crearPedidoFragment.getContext(), HomeClienteActivity.class);
        crearPedidoFragment.startActivity(intent);
    }

    public void showHomeClienteActivity(PerfilFragment perfilFragment) {
        Intent intent = new Intent(perfilFragment.getContext(), HomeClienteActivity.class);
        perfilFragment.startActivity(intent);
    }

    public void showDetallePedidoClienteFragment(DetallePedidoClienteActivity detallePedidoClienteActivity, long idPedido) {
        openFragment(detallePedidoClienteActivity, DetallePedidoClienteFragment.newInstance(idPedido), "DetallePedido", false);
    }

    public void showHomeClienteActivity(DetallePedidoClienteFragment detallePedidoClienteFragment) {
        Intent intent = new Intent(detallePedidoClienteFragment.getContext(), HomeClienteActivity.class);
        detallePedidoClienteFragment.startActivity(intent);
    }

    public void showDetallePedidoClienteActiivty(PedidosClientesFragment pedidosClientesFragment, Long idItemClicked) {
        Intent intent = new Intent(pedidosClientesFragment.getContext(), DetallePedidoClienteActivity.class);
        intent.putExtra("idPedido", idItemClicked);
        pedidosClientesFragment.startActivity(intent);
    }

    public void showDetallePedidoRestauranteFragment(DetallePedidoRestauranteActivity detallePedidoRestauranteActivity, long idPedido) {
        openFragment(detallePedidoRestauranteActivity, DetallePedidoRestauranteFragment.newInstance(idPedido), "DetallePedido", false);
    }

    public void showDetallePedidoRestauranteActivity(PedidosClientesFragment pedidosClientesFragment, Long idItemClicked) {
        Intent intent = new Intent(pedidosClientesFragment.getContext(), DetallePedidoRestauranteActivity.class);
        intent.putExtra("idPedido", idItemClicked);
        pedidosClientesFragment.startActivity(intent);
    }
}
