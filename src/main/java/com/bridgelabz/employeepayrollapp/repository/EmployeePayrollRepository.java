package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

    @Query(value = "select * from employeepayroll_db,employee_department where employee_id=id and departments= :department ", nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);
}