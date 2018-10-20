package com.ingeapp.dagger.modules;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ingeapp.core.IngeApplication;
import com.ingeapp.db.IngeDb;
import com.ingeapp.view.Navigator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Singleton;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    private final IngeApplication ingeApplication;

    public ApplicationModule(IngeApplication ingeApplication) {
        this.ingeApplication = ingeApplication;
    }

    @Provides
    @Singleton
    public IngeApplication provideMobilityApplication() {
        return this.ingeApplication;
    }

    @Provides
    @Singleton
    public Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides
    @Singleton
    IngeDb provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                IngeDb.class, "Inge.db")
                .build();
    }

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }
}
