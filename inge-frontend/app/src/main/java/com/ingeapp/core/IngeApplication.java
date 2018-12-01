package com.ingeapp.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDexApplication;

import com.ingeapp.R;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.dagger.modules.ApplicationModule;
import com.ingeapp.dagger.modules.DataModule;
import com.ingeapp.dagger.modules.ServiceModule;
import com.ingeapp.dagger.modules.ViewModelModule;
import com.ingeapp.view.activity.LoginActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class IngeApplication extends MultiDexApplication implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private IngeComponents component;
    private static IngeApplication sInstance;

    public static Context context;

    public static IngeApplication getsInstance() {
        return sInstance;
    }

    public static void setsInstance(IngeApplication instance) {
        IngeApplication.setsInstance(instance);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        context = getApplicationContext();
        if (this.component == null) {
            this.component = IngeComponents.Initializer.init(
                    new ApplicationModule(this),
                    new ServiceModule(),
                    new DataModule(this)
            );
            component.inject(this);
        }

        this.createShotcut();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    public IngeComponents getComponent() {
        return component;
    }

    public final void createShotcut() {
        Intent shortcutIntent = new Intent();
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, getIntentShortcut());
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
        shortcutIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        this.sendBroadcast(shortcutIntent);
    }

    public Intent getIntentShortcut(){
        return new Intent()
                .setClass(getApplicationContext(),LoginActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_LAUNCHER);
    }

}
