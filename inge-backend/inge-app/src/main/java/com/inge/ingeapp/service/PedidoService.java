package com.inge.ingeapp.service;

import com.inge.ingeapp.entity.*;
import com.inge.ingeapp.exception.PedidoNotFoundException;
import com.inge.ingeapp.exception.UserNotFoundException;
import com.inge.ingeapp.repository.ClienteRepository;
import com.inge.ingeapp.repository.PedidoRepository;
import com.inge.ingeapp.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PedidoService {

    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;
    private Restaurante restaurante;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository,
                         RestauranteRepository restauranteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        restaurante = restauranteRepository.findRestaurante();
    }


    public Pedido crearPedido(List<Producto> productos,
                                      Long idCliente, String direccionEntrega) throws UserNotFoundException {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(UserNotFoundException::new);
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setRestaurante(restaurante);
        pedido.setProductos(productos);
        //TODO buscar de alguna manera las coordenadas y setearlas aca (si es que hay tiempo)
        pedido.setDireccionEntrega(new Direccion(direccionEntrega, new Coordenadas()));
        pedido.setEstado(Estado.ENCOLA);
        pedidoRepository.save(pedido);
        return pedido;
    }

    @Transactional
    public void cambiarEstadoPedido(Long idPedido, Estado estado) throws PedidoNotFoundException {
        pedidoRepository.updateEstadoPedido(idPedido, estado);
    }
}



