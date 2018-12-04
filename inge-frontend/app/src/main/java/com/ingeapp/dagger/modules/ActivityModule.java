package com.ingeapp.dagger.modules;

import com.ingeapp.view.activity.HomeClienteActivity;
import com.ingeapp.view.activity.HomeRestaurantActivity;
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
    abstract HomeClienteActivity contributeHomeClienteActivity();
    
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract HomeRestaurantActivity contributeHomeRestaurantActivity();
    
    @ContributesAndroidInjector(modules = FragmentModule.class)    
    abstract SignUpActivity contributeSignUpActivity();
}