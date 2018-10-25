package com.inge.ingeapp.controller;

import com.inge.ingeapp.entity.Restaurante;
import com.inge.ingeapp.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestauranteController {

    private final RestauranteService restauranteService;

    @Autowired
    public RestauranteController(RestauranteService restauranteService){
        this.restauranteService = restauranteService;
    }

    @RequestMapping(value="/resto")
    @ResponseBody
    public Restaurante getRestaurante(@RequestParam("id") Long id){
        return restauranteService.getRestaurante(id);
    }

}
