package com.ingeapp.dagger.modules;


import android.arch.persistence.room.Room;

import com.ingeapp.core.IngeApplication;
import com.ingeapp.db.IngeDb;

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
    public IngeDb providesRoomDatabase() {
        return ingeDb;
    }

    /**
    @Singleton
    @Provides
    public AlgoDao algoDao(IngeDb ingeDb) {
        return ingeDb.algoDao();
    }

    @Singleton
    @Provides
    public AlgoRepository algoRepository(Daos que usa el repository) {
        return new AlgoRepository(args);
    }
    */

}
