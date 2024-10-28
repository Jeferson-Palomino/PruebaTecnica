package com.example.prueba.Change.domain.persistence;

import com.example.prueba.Change.domain.model.entity.Change;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRepository extends ReactiveCrudRepository<Change, Long> {
}
