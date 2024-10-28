package com.example.prueba.Change.api;

import com.example.prueba.Change.domain.service.ChangeService;
import com.example.prueba.Change.resource.ChangeRequest;
import com.example.prueba.Change.resource.ChangeResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/change")
public class ChangeController {
    private final ChangeService changeService;

    public ChangeController(ChangeService changeService) {
        this.changeService = changeService;
    }

    @PostMapping("/convert")
    public Mono<ChangeResponse> convertir(@RequestBody ChangeRequest changeRequest) {
        return changeService.save(changeRequest);
    }

    @GetMapping("/list")
    public Flux<ChangeResponse> listarConversiones() {
        return changeService.findAll();
    }
}
