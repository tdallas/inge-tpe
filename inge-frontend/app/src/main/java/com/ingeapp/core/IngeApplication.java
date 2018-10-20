package com.ingeapp.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDexApplication;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.dagger.modules.ApplicationModule;
import com.ingeapp.dagger.modules.DataModule;
import com.ingeapp.dagger.modules.ServiceModule;
import com.ingeapp.dagger.modules.ViewModelModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class IngeApplication extends Application implements HasActivityInjector {
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
//            this.component = PortalComponents.Initializer.init(this);
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


    // ---

    public final void createShotcut() {
        /* if(!getSharedPreferences(getString(R.string.SHARED_DATA), Activity.MODE_PRIVATE)
                .getBoolean(getString(R.string.SHARED_IS_DESKTOP_ICON_CREATED), false)){
            Intent shortcutIntent = new Intent();
            shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, getIntentShortcut());
            shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
//            shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(this.getApplicationContext(), R.drawable.mobility_icon_desktop));
            shortcutIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            this.sendBroadcast(shortcutIntent);
            getSharedPreferences(getString(R.string.SHARED_DATA), Activity.MODE_PRIVATE)
                    .edit().putBoolean(getString(R.string.SHARED_IS_DESKTOP_ICON_CREATED), true).apply();
        } */
    }

    public Intent getIntentShortcut(){
       /* return new Intent()
                .setClass(getApplicationContext(),LoginActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setAction(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_LAUNCHER); */
       return null;
    }

}
