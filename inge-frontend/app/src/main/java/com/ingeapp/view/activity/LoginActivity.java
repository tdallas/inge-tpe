package com.ingeapp.view.activity;

import android.widget.Toolbar;

import com.ingeapp.R;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.view.Navigator;

public class LoginActivity extends IngeActivity {
    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public Navigator getNavigator() {
        return null;
    }

    @Override
    public Toolbar getToolbar() {
        return null;
    }

    @Override
    protected void injectDependencies(IngeComponents portalComponents) {

    }
}
