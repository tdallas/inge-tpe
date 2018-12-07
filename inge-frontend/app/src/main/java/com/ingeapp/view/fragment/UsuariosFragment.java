package com.ingeapp.view.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ingeapp.R;
import com.ingeapp.model.entities.Cliente;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.model.viewModel.UsuariosViewModel;
import com.ingeapp.util.UsuariosAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class UsuariosFragment extends IngeFragment {

    UsuariosViewModel usuariosViewModel;

    UsuariosAdapter usuariosAdapter = new UsuariosAdapter();

    @BindView(R.id.recycler_usuarios)
    RecyclerView usuarios;

    @Override
    protected List<IngeViewModel> getViewModels() {
        return new ArrayList<IngeViewModel>(Collections.singletonList(usuariosViewModel));
    }

    public void onCreate(Bundle savedInstanceState) {
        usuariosViewModel = ViewModelProviders.of(this).get(UsuariosViewModel.class);
        super.onCreate(savedInstanceState);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        usuarios.setLayoutManager(new LinearLayoutManager(getContext()));
        usuarios.setAdapter(usuariosAdapter);
    }

    public void onResume() {
        super.onResume();
        usuariosViewModel.getUsuarios().observe(this, new Observer<List<Cliente>>() {
            @Override
            public void onChanged(@Nullable List<Cliente> clientes) {
                usuariosAdapter.setList(clientes);
                usuariosAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_ver_usuarios;
    }
}
