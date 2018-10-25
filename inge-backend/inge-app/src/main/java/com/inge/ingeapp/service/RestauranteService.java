package com.inge.ingeapp.service;

import com.inge.ingeapp.entity.Restaurante;
import com.inge.ingeapp.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    @Autowired
    public RestauranteService(RestauranteRepository restauranteRepository){
        this.restauranteRepository = restauranteRepository;
    }

    //FIXME CATCHEAR EXCEPTIPON O DEVOLVER UN OBJETO VACIO
    public Restaurante getRestaurante(Long id) throws Throwable {
        return restauranteRepository.findById(id).orElseThrow((Supplier<Throwable>) NoSuchElementException::new);
    }

}
