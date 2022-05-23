package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name="employee")
public class EmployeePayrollData {
    @Id
    @Column(name="id")
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData() {
        // TODO Auto-generated constructor stub
    }
    public EmployeePayrollData(int employeeId, String name, long salary) {
        super();
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }
    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {

        super();
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }

}
