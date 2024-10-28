package com.example.prueba.Change.resource;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ChangeResponse {
    private BigDecimal monto;
    private BigDecimal montoConvertido;
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal tipoCambio;
    private LocalDateTime fechaTransaccion;

    public ChangeResponse(BigDecimal montoOriginal, BigDecimal montoConvertido, String monedaOrigen, String monedaDestino, BigDecimal tipoCambio, LocalDateTime fechaTransaccion) {
        this.monto = montoOriginal;
        this.montoConvertido = montoConvertido;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tipoCambio = tipoCambio;
        this.fechaTransaccion = fechaTransaccion;
    }
}
