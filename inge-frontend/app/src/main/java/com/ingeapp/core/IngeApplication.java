package com.ingeapp.core;

import android.content.Intent;
import android.support.multidex.MultiDexApplication;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.dagger.modules.ApplicationModule;
import com.ingeapp.dagger.modules.DataModule;
import com.ingeapp.dagger.modules.ViewModelModule;

public class IngeApplication extends MultiDexApplication {

    private IngeComponents component;
    private static IngeApplication sInstance;

    public static IngeApplication getInstance() {
        return sInstance;
    }

    public static void setInstance(IngeApplication sInstance) {
        IngeApplication.sInstance = sInstance;
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        sInstance = this;
        if (this.component == null) {
            this.component = IngeComponents.Initializer.init(
                    new ApplicationModule(this),
                    new DataModule(this),
                    new ViewModelModule()
            );
        }
        this.createShotcut();
    }

    public void recreateComp(){
        this.component = IngeComponents.Initializer.init(
                new ApplicationModule(this),
                new DataModule(this),
                new ViewModelModule()
        );
    }

    public IngeComponents getComponent() {
        return component;
    }

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
