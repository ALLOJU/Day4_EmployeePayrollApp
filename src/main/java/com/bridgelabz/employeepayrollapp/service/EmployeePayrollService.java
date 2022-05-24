package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.Exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
        return employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == employeeId).findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        employeePayrollList.add(empData);
        log.debug("Employee Data: " + empData.toString());
        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
        empData.setName(empPayrollDTO.name);
        empData.setSalary(empPayrollDTO.salary);
        employeePayrollList.set(employeeId - 1, empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int employeeId) {
        employeePayrollList.remove(employeeId - 1);
    }
}
