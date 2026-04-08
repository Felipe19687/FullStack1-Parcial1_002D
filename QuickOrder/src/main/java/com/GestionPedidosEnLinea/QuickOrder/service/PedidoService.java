package com.GestionPedidosEnLinea.QuickOrder.service;

import com.GestionPedidosEnLinea.QuickOrder.model.Estado;
import com.GestionPedidosEnLinea.QuickOrder.model.Pedido;
import com.GestionPedidosEnLinea.QuickOrder.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public Pedido crear(Pedido pedido) {
        pedido.setFechaPedido(LocalDate.now());
        return PedidoRepository.guardar(pedido); // delego al repository que guarde los datos
    }


    public List<Pedido> buscarTodos(){
        return pedidoRepository.buscarTodos();
    }

    //BUSCAR POR ID
    public Pedido buscarPorId(Long id){
        return PedidoRepository.buscarPorId(id);

    }

    //ACTUALIZAR
    public Pedido actualizar(Long id, Pedido pedidoActualizado) {
        Pedido pedidoExistente = pedidoRepository.buscarPorId(id);
        if (pedidoExistente != null) {
            pedidoActualizado.setId(id);
            pedidoActualizado.setFechaPedido(pedidoExistente.getFechaPedido());
            return pedidoRepository.actualizar(pedidoActualizado);
        }
        return null;
    }

    //ELIMINAR
    public Pedido eliminar(Long id){
        return PedidoRepository.eliminar(id);
    }

    //BUSCAR POR ESTADO
    public List<Pedido> buscarPorEstado(Estado estado){
        return PedidoRepository.buscarPorEstado(estado);
    }
}