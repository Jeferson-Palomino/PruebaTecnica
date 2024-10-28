package com.example.prueba.Change.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class ExchangeRateService {
    private final WebClient webClient;
    private static final Logger logger = LoggerFactory.getLogger(ExchangeRateService.class);
    public ExchangeRateService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://open.er-api.com/v6/latest").build();
    }

    public Mono<BigDecimal> getChangeType(String monedaOrigen, String monedaDestino) {
        logger.info("Service external ");
        return webClient.get()
                .uri("/{monedaOrigen}", monedaOrigen)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(json -> new BigDecimal(json.path("rates").path(monedaDestino).asText()));
    }

}
