package com.inge.ingeapp.controller;

import com.inge.ingeapp.controller.request.ComboRequest;
import com.inge.ingeapp.service.ComboService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComboController {

    private final ComboService comboService;

    public ComboController(ComboService comboService) {
        this.comboService = comboService;
    }

    @PostMapping(value = "/crearCombo")
    @ResponseBody
    public ResponseEntity<?> crearCombo(ComboRequest comboRequest) {
        comboService.createCombo(comboRequest);
        return ResponseEntity.ok().build();
    }
}
