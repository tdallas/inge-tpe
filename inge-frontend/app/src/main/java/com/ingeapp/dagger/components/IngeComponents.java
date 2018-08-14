package com.ingeapp.dagger.components;

import com.ingeapp.dagger.modules.ApplicationModule;
import com.ingeapp.dagger.modules.DataModule;
import com.ingeapp.dagger.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DataModule.class,
                ViewModelModule.class
        }
)
public interface IngeComponents {

    /**
     * Here goes inject for activities
     */


    /**
     * Here goes inject for fragments
     */

    final class Initializer {
        public static IngeComponents init(ApplicationModule applicationModule,
                                            DataModule dataModule,
                                            ViewModelModule viewModelModule) {
            return DaggerIngeComponents
                    .builder()
                    .applicationModule(applicationModule)
                    .dataModule(dataModule)
                    .viewModelModule(viewModelModule)
                    .build();
        }
    }

}
