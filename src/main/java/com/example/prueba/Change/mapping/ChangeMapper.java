package com.example.prueba.Change.mapping;

import com.example.prueba.Change.domain.model.entity.Change;
import com.example.prueba.Change.resource.ChangeRequest;
import com.example.prueba.Change.resource.ChangeResponse;
import com.example.prueba.Change.service.ChangeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ChangeMapper {
    private static final Logger logger = LoggerFactory.getLogger(ChangeMapper.class);
    public static Change toModelChange(ChangeRequest changeRequest, BigDecimal typeChange, BigDecimal  montoConvert){
        logger.info("Mapper : {}", changeRequest);
        logger.info("Mapper : {}", typeChange);
        logger.info("Mapper : {}", montoConvert);
        return new Change(
                null,
                changeRequest.getMonto(),
                montoConvert,
                changeRequest.getMonedaOrigen(),
                changeRequest.getMonedaDestino(),
                typeChange,
                LocalDateTime.now()
        );
    }

    public static ChangeResponse toDto(Change change){
        logger.info("Service : {}", change);
        return new ChangeResponse(
                change.getMontooriginal(),
                change.getMontoconvertido(),
                change.getMonedaorigen(),
                change.getMonedadestino(),
                change.getTipocambio(),
                change.getFechatransaccion()
        );
    }
}
