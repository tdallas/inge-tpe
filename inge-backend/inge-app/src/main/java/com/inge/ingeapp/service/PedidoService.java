package com.inge.ingeapp.service;

import com.inge.ingeapp.controller.request.CalificarRequest;
import com.inge.ingeapp.entity.*;
import com.inge.ingeapp.exception.PedidoNotFoundException;
import com.inge.ingeapp.exception.UserNotFoundException;
import com.inge.ingeapp.repository.ClienteRepository;
import com.inge.ingeapp.repository.PedidoRepository;
import com.inge.ingeapp.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
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
        restaurante = restauranteRepository.findRestauranteByNombre("Administrador");
    }


    public Pedido crearPedido(List<Producto> productos,
                                      Long idCliente, String direccion) throws UserNotFoundException {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(UserNotFoundException::new);
        Date now = new Date();
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setRestaurante(restaurante);
        pedido.setProductos(productos);
        pedido.setDireccionEntrega(direccion);
        pedido.setEstado("PROCESANDO");
        pedido.setHoraRealizado(now);
        pedido.setPrecio(pedido.getPrecioTotal());
        now.setHours(now.getHours()+1);
        pedido.setHoraEntrega(now);
        pedidoRepository.save(pedido);
        return pedido;
    }

    @Transactional
    public void cambiarEstadoPedido(Long idPedido, Estado estado) throws PedidoNotFoundException {
        pedidoRepository.updateEstadoPedido(idPedido, estado);
    }

    public List<Pedido> findAllPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> findAllPedidosById(Long idUser) {
        return pedidoRepository.findAllByUserId(idUser);
    }

    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id).get();
    }

    @Transactional
    public boolean calificar(CalificarRequest calificarRequest) {
        pedidoRepository.calificar(calificarRequest);
        return true;
    }
}



