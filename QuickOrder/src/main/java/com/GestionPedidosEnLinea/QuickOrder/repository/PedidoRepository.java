package com.GestionPedidosEnLinea.QuickOrder.repository;
import org.springframework.stereotype.Repository;
import com.GestionPedidosEnLinea.QuickOrder.model.Pedido;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PedidoRepository {
    private final Map<Long, Pedido> pedidos = new HashMap<>();
    private Long contadorId = 1L;

    public Pedido buscarPorId(Long id) {
        return pedidos.get(id);
    }

    public Pedido guardar(Pedido pedido) {
        pedido.setId(contadorId++);
        pedidos.put(pedidos.get(id), pedido);
        return pedido;


    }

    public List<Pedido> buscarTodos() {
        return new ArrayList<>(pedidos.values());
    }

    public Pedido actualizar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido); //actualiza
        return pedido;
    }

    public Pedido eliminar(Long id) {
        return pedidos.remove(id);
    }


    public List<Pedido> buscarPorEstado(Pedido pedido) {
        return pedidos.values().stream()
                .filter(i -> i.getEstado() == estado)
                .collect(Collectors.toList());
    }
}
