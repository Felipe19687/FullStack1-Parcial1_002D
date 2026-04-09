package com.GestionPedidosEnLinea.QuickOrder.controller;

import com.GestionPedidosEnLinea.QuickOrder.model.Estado;
import com.GestionPedidosEnLinea.QuickOrder.model.Pedido;
import com.GestionPedidosEnLinea.QuickOrder.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodos(){
        return new ResponseEntity<>(pedidoService.buscarTodos(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Pedido> crear(@Valid @RequestBody Pedido pedido) {
        Pedido nuevoPedido = pedidoService.crear(pedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPorId(id);
        if (pedido != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Long id, @Valid @RequestBody Pedido pedido){
        Pedido actualizado = pedidoService.actualizar(id, pedido);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        pedidoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Pedido>> buscarPorEstado(@PathVariable Estado estado){
        List<Pedido> filtrados = pedidoService.buscarPorEstado(estado);
        return new ResponseEntity<>(filtrados, HttpStatus.OK);
    }
}
