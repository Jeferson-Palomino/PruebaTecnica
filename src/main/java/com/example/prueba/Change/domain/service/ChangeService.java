package com.example.prueba.Change.domain.service;

import com.example.prueba.Change.resource.ChangeRequest;
import com.example.prueba.Change.resource.ChangeResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ChangeService{
    public Mono<ChangeResponse> save(ChangeRequest changeRequest);
    public Flux<ChangeResponse> findAll();
}
