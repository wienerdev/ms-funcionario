package com.eldorado.ms.funcionario.service;

import com.eldorado.ms.funcionario.domain.model.EmployeeEntity;
import com.eldorado.ms.funcionario.domain.repository.EmployeeRepository;
import com.eldorado.ms.funcionario.dto.CustomEmployeeList;
import com.eldorado.ms.funcionario.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeDto createEmployee(@Validated EmployeeDto dto) {
        var employeeEntity = modelMapper.map(dto, EmployeeEntity.class);

        employeeEntity.setEmployeeCode(UUID.randomUUID());

        employeeEntity = employeeRepository.save(employeeEntity);
        log.info("Employee Saved with sucefull {}", employeeEntity);

        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();

        return modelMapper.map(employeeList, CustomEmployeeList.class);
    }

    @SneakyThrows
    public EmployeeDto getEmployeeById(UUID id) {
        var employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("EMPLOYEE NOT FOUND"));

        return modelMapper.map(employee, EmployeeDto.class);
    }

    @SneakyThrows
    public EmployeeDto updateEmployee(@Validated EmployeeDto dto) {

        var employee = employeeRepository.findById(dto.getEmployeeCode())
                .orElseThrow(() -> new Exception("EMPLOYEE NOT FOUND"));

        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}
