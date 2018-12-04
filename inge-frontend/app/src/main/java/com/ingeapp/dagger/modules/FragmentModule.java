package com.ingeapp.dagger.modules;

import com.ingeapp.view.fragment.LoginFragment;
import com.ingeapp.view.fragment.SignUpFragment;

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
    abstract SignUpFragment contributeSignUpFragment();
}