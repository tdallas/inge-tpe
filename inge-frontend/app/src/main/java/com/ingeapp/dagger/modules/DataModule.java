package com.ingeapp.dagger.modules;

import android.arch.persistence.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ingeapp.core.IngeApplication;
import com.ingeapp.db.IngeDb;
import com.ingeapp.db.LoginRepository;
import com.ingeapp.db.ProductoRepository;
import com.ingeapp.db.SignUpRepository;
import com.ingeapp.service.LoginService;
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
    public LoginRepository providesLoginRepository(LoginService loginService) {
        return new LoginRepository(loginService);
    }

    @Singleton
    @Provides
    public SignUpRepository providesSignUpRepository(SignUpService signUpService) {
        return new SignUpRepository(signUpService);
    }

    @Singleton
    @Provides
    public ProductoRepository providesProductoRepository(ProductoService productoService) {
        return new ProductoRepository(productoService);
    }

    @Provides
    @Singleton
    public Gson provideGson(){
        return new GsonBuilder()
                .setLenient()
                .create();
    }

}
