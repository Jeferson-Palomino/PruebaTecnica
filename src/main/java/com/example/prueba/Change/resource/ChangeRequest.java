package com.example.prueba.Change.resource;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ChangeRequest {
    private BigDecimal monto;
    private String monedaOrigen;
    private String monedaDestino;
}
