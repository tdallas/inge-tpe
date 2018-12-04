package com.ingeapp.model.viewModel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;

import com.ingeapp.dagger.components.IngeComponents;

public abstract class IngeViewModel extends ViewModel {
    public abstract void initialize(IngeComponents component);
}
