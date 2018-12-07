package com.ingeapp.dagger.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ingeapp.core.IngeApplication;
import com.ingeapp.db.IngeDb;
import com.ingeapp.db.LoginRepository;
import com.ingeapp.db.PedidoRepository;
import com.ingeapp.db.PerfilRepository;
import com.ingeapp.db.ProductoRepository;
import com.ingeapp.db.SignUpRepository;
import com.ingeapp.service.LoginService;
import com.ingeapp.service.PedidoService;
import com.ingeapp.service.PerfilService;
import com.ingeapp.service.ProductoService;
import com.ingeapp.service.SignUpService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    private IngeDb ingeDb;

    public DataModule(IngeApplication mApplication) {
        ingeDb = Room.databaseBuilder(mApplication, IngeDb.class, "inge-db").fallbackToDestructiveMigration().build();
    }

    @Singleton
    @Provides
    IngeDb providesRoomDatabase() {
        return ingeDb;
    }
/*
    @Singleton
    @Provides
    public MissionDao missionDao(BoostDb boostDb){
        return boostDb.missionDao();
    }
*/
    @Singleton
    @Provides
    public LoginRepository providesLoginRepository(LoginService loginService, Context context) {
        return new LoginRepository(loginService, context);
    }

    @Singleton
    @Provides
    public SignUpRepository providesSignUpRepository(SignUpService signUpService, Context context) {
        return new SignUpRepository(signUpService, context);
    }

    @Singleton
    @Provides
    public ProductoRepository providesProductoRepository(ProductoService productoService) {
        return new ProductoRepository(productoService);
    }

    @Singleton
    @Provides
    public PedidoRepository providesPedidoRepository(PedidoService pedidoService) {
        return new PedidoRepository(pedidoService);
    }

    @Singleton
    @Provides
    public PerfilRepository providesPerfilRepository(PerfilService perfilService, Context context) {
        return new PerfilRepository(perfilService, context);
    }

    @Provides
    @Singleton
    public Gson provideGson(){
        return new GsonBuilder()
                .setLenient()
                .create();
    }

}
