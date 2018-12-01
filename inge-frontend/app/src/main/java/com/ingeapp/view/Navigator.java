package com.ingeapp.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.ingeapp.R;
import com.ingeapp.view.activity.IngeActivity;
import com.ingeapp.view.activity.LoginActivity;
import com.ingeapp.view.fragment.LoginFragment;

/**
 * this class is use to navigate between activities and fragments
 */
public class Navigator {

    public Navigator() {

    }

    /**
     * Activities
     * public ..(Activity from, params)
     * Intent intent = new Intent(from.getApplicationContext(), MyClassActivity.class);
     * intent = MyClassActivity.putParams(*);
     * from.startActivity(intent);
     */

    /**
     * Fragments
     * <p>
     * function declaration(params)
     * openFragment(ActivityFrom, fragment, fragment name, addToBackStack?
     */


    public void showLoginFragment(LoginActivity loginActivity) {
        openFragment(loginActivity, new LoginFragment(), "LoginFragment", false);
    }

    private Fragment openFragment(IngeActivity from, Fragment fragment, String name, boolean addToBackStack) {
        FragmentTransaction transaction = from.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.content_frame, fragment, name);
        if (addToBackStack)
            transaction.addToBackStack(name);
        from.setTitle(name);
        transaction.commit();
        from.invalidateOptionsMenu();
        return fragment;
    }

}
