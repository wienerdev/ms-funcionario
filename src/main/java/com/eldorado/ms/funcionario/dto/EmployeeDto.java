package com.eldorado.ms.funcionario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    private UUID employeeCode;
    private String name;
    private String post;
    private char gender;
}
