package com.ingeapp.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ingeapp.core.IngeApplication;
import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.model.viewModel.IngeViewModel;
import com.ingeapp.view.activity.IngeActivity;
import com.ingeapp.view.fragmentView.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public abstract class IngeFragment extends Fragment implements View {

    @Inject
    IngeApplication ingeApplication;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iniciarViewModels(getViewModels());
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(getViewId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    protected void iniciarViewModels(List<IngeViewModel> viewModels) {
        if (viewModels == null || viewModels.size() == 0)
            return;
        for (IngeViewModel p : viewModels) {
            p.initialize(ingeApplication.getComponent());
        }
    }

    protected abstract List<IngeViewModel> getViewModels();

    protected IngeComponents getComponent(){
        return ((IngeApplication) getActivity().getApplication()).getComponent();
    }

    protected abstract int getViewId();

    public void showToastError(String error) {
        if(getContext()!=null) {
            Toast toast = Toast.makeText(getContext(), error, Toast.LENGTH_LONG);
            toast.show();
        }
    }


}
