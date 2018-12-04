package com.ingeapp.dagger.modules;

import com.ingeapp.view.fragment.HomeClienteFragment;
import com.ingeapp.view.fragment.HomeRestaurantFragment;
import com.ingeapp.view.fragment.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    /**
     *
     *
     @ContributesAndroidInjector
     abstract UserProfileFragment contributeUserProfileFragment();
     */

    @ContributesAndroidInjector
    abstract LoginFragment contributeLoginFragment();
    @ContributesAndroidInjector
    abstract HomeClienteFragment contributeHomeClienteFragment();
    @ContributesAndroidInjector
    abstract HomeRestaurantFragment contributeHomeRestaurantFragment();
}