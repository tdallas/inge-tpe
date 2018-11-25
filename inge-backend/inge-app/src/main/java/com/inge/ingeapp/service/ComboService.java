package com.inge.ingeapp.service;

import com.inge.ingeapp.controller.request.ComboRequest;
import com.inge.ingeapp.entity.Combo;
import com.inge.ingeapp.repository.ComboRepository;
import org.springframework.stereotype.Component;

@Component
public class ComboService {
    private final ComboRepository comboRepository;

    public ComboService(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;
    }

    public void createCombo(ComboRequest comboRequest) {
        comboRepository.save(new Combo(comboRequest.getProductos()));
    }
}
