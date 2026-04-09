package com.GestionPedidosEnLinea.QuickOrder.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
//Clase Getter Setter y construtor vacio Sin Lombok

public class Pedido {
    private Long id;

    @NotBlank(message = "El Nombre No puede estar vacio")
    private String nombreCliente;

    @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;

    @NotNull(message = "El estado es obligatorio")
    private Estado estado;

    @NotNull(message = "El tipo de pedido es obligatorio")
    private TipoPedido tipoPedido;

    @Positive(message = "El monto total debe ser mayor a cero")
    private Double montoTotal;

    private LocalDate fechaPedido;

    // Constructor vacío
    public Pedido() {
    }

    // Constructor Completo
    public Pedido(Long id, String nombreCliente, String descripcion,
                  Estado estado, TipoPedido tipoPedido,
                  Double montoTotal, LocalDate fechaPedido) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoPedido = tipoPedido;
        this.montoTotal = montoTotal;
        this.fechaPedido = fechaPedido;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
}