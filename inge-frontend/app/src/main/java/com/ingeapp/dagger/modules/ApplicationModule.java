package com.ingeapp.dagger.modules;

import com.ingeapp.core.IngeApplication;
import com.ingeapp.view.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
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

}
