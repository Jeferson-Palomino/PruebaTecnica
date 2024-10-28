package com.example.prueba.Change.service;

import com.example.prueba.Change.domain.persistence.ChangeRepository;
import com.example.prueba.Change.domain.service.ChangeService;
import com.example.prueba.Change.exception.ResourceNotFoundException;
import com.example.prueba.Change.mapping.ChangeMapper;
import com.example.prueba.Change.resource.ChangeRequest;
import com.example.prueba.Change.resource.ChangeResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static com.example.prueba.Change.mapping.ChangeMapper.toModelChange;

@Service
@RequiredArgsConstructor
public class ChangeServiceImpl implements ChangeService {
    private final ChangeRepository changeRepository;
    private final ExchangeRateService exchangeRateService;
    private static final Logger logger = LoggerFactory.getLogger(ChangeServiceImpl.class);

    @Override
    public Mono<ChangeResponse> save(ChangeRequest changeRequest) {
        logger.info("Service : {}", changeRequest);
        return exchangeRateService.getChangeType(changeRequest.getMonedaOrigen(),changeRequest.getMonedaDestino())
                .flatMap(typeChange ->{
                    BigDecimal montoConvertido = changeRequest.getMonto().multiply(typeChange);
                    logger.info("Service convert : {}", montoConvertido);
                    logger.info("Service convert : {}", typeChange);
                    return changeRepository.save(toModelChange(changeRequest,typeChange,montoConvertido))
                            .map(ChangeMapper::toDto)
                            .onErrorMap(ex -> {
                                logger.error("Error al guardar en la base de datos", ex);
                                return new ResourceNotFoundException("Error el crear cliente");
                            });
                });
    }

    @Override
    public Flux<ChangeResponse> findAll() {
        return changeRepository.findAll()
                .map(ChangeMapper::toDto);
    }
}
