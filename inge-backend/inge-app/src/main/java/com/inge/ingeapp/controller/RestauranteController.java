package com.inge.ingeapp.controller;

import com.inge.ingeapp.entity.Restaurante;
import com.inge.ingeapp.entity.Rol;
import com.inge.ingeapp.repository.RolRepository;
import com.inge.ingeapp.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestauranteController implements CommandLineRunner {

    private final RestauranteService restauranteService;
    private final RolRepository rolRepository;

    @Autowired
    public RestauranteController(RestauranteService restauranteService, RolRepository rolRepository){
        this.restauranteService = restauranteService;
        this.rolRepository = rolRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (rolRepository.findById(1L).isPresent())
            return;
        Rol restaurant = new Rol(1L, "RESTAURANTE");
        rolRepository.save(restaurant);
        Rol cliente = new Rol(2L, "CLIENTE");
        rolRepository.save(cliente);
        Restaurante restaurante = new Restaurante("Administrador", "", "admin@admin.com",
                "ad1234", restaurant, "39758804", "123123412");
        restauranteService.saveRestaurant(restaurante);
    }
}
