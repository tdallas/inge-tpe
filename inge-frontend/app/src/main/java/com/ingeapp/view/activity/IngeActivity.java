package com.ingeapp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.Toolbar;

import com.ingeapp.core.IngeApplication;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.util.CommonUtils;
import com.ingeapp.view.Navigator;

import butterknife.ButterKnife;

import static android.widget.Toast.LENGTH_SHORT;

public abstract class IngeActivity extends AppCompatActivity {

    //public Drawer menuDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayout());

        this.injectDependencies(this.getComponent());

        ButterKnife.bind(this);

        Toolbar toolbar = getToolbar();
        if (toolbar != null) {
            //createMenuDrawer(toolbar);
        }

        CommonUtils.verificoYPidoPermisos(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected IngeComponents getComponent() {
        return ((IngeApplication) getApplication()).getComponent();
    }

    /*
    public void onBackPressed() {
        if (menuDrawer != null && this.menuDrawer.isDrawerOpen()) {
            this.menuDrawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
    */

    public IngeActivity getActivity() {
        return this;
    }

    public abstract int getLayout();

    public abstract Navigator getNavigator();

    public abstract Toolbar getToolbar();

    protected abstract void injectDependencies(IngeComponents portalComponents);

    public void showToastError(String error) {
        if (getApplicationContext() != null) {
            Toast toast = Toast.makeText(getApplicationContext(), error, LENGTH_SHORT);
            toast.show();
        }
    }

}
