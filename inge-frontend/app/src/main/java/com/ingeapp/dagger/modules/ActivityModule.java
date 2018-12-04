package com.ingeapp.dagger.modules;

import com.ingeapp.view.activity.LoginActivity;
import com.ingeapp.view.activity.SignUpActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    /**
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();
    **/

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract LoginActivity contributeLoginActivity();

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract SignUpActivity contributeSignUpActivity();
}