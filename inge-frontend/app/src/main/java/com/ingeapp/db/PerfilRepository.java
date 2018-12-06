package com.ingeapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ingeapp.service.PerfilService;
import com.ingeapp.service.payload.UpdateRequest;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class PerfilRepository {
    private final PerfilService perfilService;
    private MutableLiveData<Boolean> update = new MutableLiveData<>();

    public PerfilRepository(PerfilService perfilService) {
        this.perfilService = perfilService;
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
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });
        return update;
    }
}
