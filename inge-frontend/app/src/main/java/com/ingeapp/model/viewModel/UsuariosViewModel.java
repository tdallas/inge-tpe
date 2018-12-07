package com.ingeapp.model.viewModel;

import android.arch.lifecycle.LiveData;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.db.PerfilRepository;
import com.ingeapp.model.entities.Cliente;

import java.util.List;

import javax.inject.Inject;

public class UsuariosViewModel extends IngeViewModel {

    @Inject
    PerfilRepository perfilRepository;

    @Override
    public void initialize(IngeComponents component) {
        component.inject(this);
    }

    public LiveData<List<Cliente>> getUsuarios() {
        return perfilRepository.getCliente();
    }
}
