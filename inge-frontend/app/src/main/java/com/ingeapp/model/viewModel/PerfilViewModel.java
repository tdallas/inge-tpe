package com.ingeapp.model.viewModel;

import android.arch.lifecycle.LiveData;
import android.text.Editable;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.db.PerfilRepository;
import com.ingeapp.service.payload.UpdateRequest;

import javax.inject.Inject;

public class PerfilViewModel extends IngeViewModel {

    @Inject
    PerfilRepository perfilRepository;

    @Override
    public void initialize(IngeComponents component) {
        component.inject(this);
    }

    public LiveData<Boolean> saveChanges(String mailActual, String claveActual, String mail, String clave, String telefono, String direccion,
                                         Long idUser) {
        return perfilRepository.updateInfo(new UpdateRequest(mailActual, claveActual, mail,clave,telefono,direccion,idUser));
    }
}
