package com.ingeapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ingeapp.core.IngeApplication;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.view.activity.IngeActivity;
import com.ingeapp.view.fragmentView.View;

import butterknife.ButterKnife;

public abstract class IngeFragment extends Fragment implements View {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies(getComponent());
    }

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(getViewId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    protected IngeComponents getComponent(){
        return ((IngeApplication) getActivity().getApplication()).getComponent();
    }

    protected IngeActivity getPortalActivity()
    {
        return (IngeActivity)   getActivity();
    }

    protected abstract int getViewId();

    protected abstract void injectDependencies(IngeComponents portalComponents);

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
    }

}
