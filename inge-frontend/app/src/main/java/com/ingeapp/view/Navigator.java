package com.ingeapp.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.ingeapp.R;
import com.ingeapp.view.activity.IngeActivity;
import com.ingeapp.view.activity.LoginActivity;
import com.ingeapp.view.activity.SignUpActivity;
import com.ingeapp.view.fragment.LoginFragment;
import com.ingeapp.view.fragment.SignUpFragment;

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

    public void showSignUpActivity(LoginFragment from) {
        Intent intent = new Intent(from.getContext(), SignUpActivity.class);
        from.startActivity(intent);
    }

    public void showSignUpFragment(SignUpActivity signUpActivity) {
        openFragment(signUpActivity, new SignUpFragment(), "SignUpFragment", false);
    }

    public void showLoginActivity(SignUpFragment from) {
        Intent intent = new Intent(from.getContext(), LoginActivity.class);
        from.startActivity(intent);
    }

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
