package com.ingeapp.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.ingeapp.R;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.view.Navigator;

import javax.inject.Inject;

public class LoginActivity extends IngeActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);
        navigator.showLoginFragment(this);
    }

    @Override
    protected void injectDependencies(IngeComponents ingeComponents) {
        ingeComponents.inject(this);
    }
}
