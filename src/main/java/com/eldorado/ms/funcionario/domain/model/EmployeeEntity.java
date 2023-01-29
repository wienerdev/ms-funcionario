package com.eldorado.ms.funcionario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("funcionario")
public class EmployeeEntity {

    @Id
    private UUID employeeCode;

    @NonNull
    private String name;

    private String post;

    private char gender;

}
