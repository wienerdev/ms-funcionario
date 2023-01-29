package com.eldorado.ms.funcionario.domain.repository;

import com.eldorado.ms.funcionario.domain.model.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, UUID> {
}
