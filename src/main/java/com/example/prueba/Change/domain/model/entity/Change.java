package com.example.prueba.Change.domain.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "cambios")
public class Change {
    @Id
    private Long id;
    private BigDecimal montooriginal;
    private BigDecimal montoconvertido;
    private String monedaorigen;
    private String monedadestino;
    private BigDecimal tipocambio;
    private LocalDateTime fechatransaccion;

    public Change(Long id, BigDecimal montoOriginal, BigDecimal montoConvertido, String monedaOrigen, String monedaDestino, BigDecimal tipoCambio, LocalDateTime fechaTransaccion) {
        this.id = id;
        this.montooriginal = montoOriginal;
        this.montoconvertido = montoConvertido;
        this.monedaorigen = monedaOrigen;
        this.monedadestino = monedaDestino;
        this.tipocambio = tipoCambio;
        this.fechatransaccion = fechaTransaccion;
    }
}
