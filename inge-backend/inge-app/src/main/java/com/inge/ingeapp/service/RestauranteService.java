package com.inge.ingeapp.service;

import com.inge.ingeapp.entity.Restaurante;
import com.inge.ingeapp.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    @Autowired
    public RestauranteService(RestauranteRepository restauranteRepository){
        this.restauranteRepository = restauranteRepository;
    }

    public Restaurante getRestaurante(Long id){
        return restauranteRepository.getOne(id);
    }

}
