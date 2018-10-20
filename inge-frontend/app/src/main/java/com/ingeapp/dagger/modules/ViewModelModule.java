package com.ingeapp.dagger.modules;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    /**
    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel.class)
    abstract ViewModel bindUserProfileViewModel(UserProfileViewModel repoViewModel);
**/
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}