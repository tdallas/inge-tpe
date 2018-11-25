package com.inge.ingeapp.controller.request;

import com.inge.ingeapp.entity.Producto;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
public class ComboRequest {
    List<Producto> productos;
}
