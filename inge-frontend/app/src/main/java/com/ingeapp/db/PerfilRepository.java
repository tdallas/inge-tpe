package com.ingeapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.SharedPreferences;

import com.ingeapp.model.entities.Cliente;
import com.ingeapp.service.PerfilService;
import com.ingeapp.service.payload.UpdateRequest;

import java.util.List;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class PerfilRepository {
    private final PerfilService perfilService;
    private final Context context;
    private MutableLiveData<Boolean> update = new MutableLiveData<>();
    private MutableLiveData<List<Cliente>> clientes = new MutableLiveData<>();

    public PerfilRepository(PerfilService perfilService, Context context) {
        this.perfilService = perfilService;
        this.context = context;
    }

    public LiveData<Boolean> updateInfo(final UpdateRequest updateRequest) {
        update = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                perfilService.updateInfo(updateRequest).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.body() != null && response.body()) {
                            update.postValue(true);
                        } else {
                            update.postValue(false);
                        }
                        SharedPreferences.Editor editor = context.getSharedPreferences("Pref", Context.MODE_PRIVATE).edit();
                        editor.putString("dir", updateRequest.getDirecction());
                        editor.apply();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });
        return update;
    }

    public LiveData<List<Cliente>> getCliente() {
        clientes = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                perfilService.getUsuarios().enqueue(new Callback<List<Cliente>>() {
                    @Override
                    public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                        clientes.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Cliente>> call, Throwable t) {

                    }
                });
            }
        });
        return clientes;
    }
}
