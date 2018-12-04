package com.ingeapp.view.activity;

import android.os.Bundle;

import com.ingeapp.R;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.view.Navigator;

import javax.inject.Inject;

public class HomeRestaurantActivity extends IngeActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void injectDependencies(IngeComponents portalComponents) {
        portalComponents.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_blank);
        super.onCreate(savedInstanceState);
        navigator.showHomeRestaurantFragment(this);
    }
}
