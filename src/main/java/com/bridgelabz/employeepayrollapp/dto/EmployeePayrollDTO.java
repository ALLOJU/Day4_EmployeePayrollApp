package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    @NotEmpty(message = "Employee Name can't be null")
    public String name;

    @Min(value = 500, message = "Min Wage should be more than 500")
    public long salary;

    @Pattern(regexp = "male|female", message = " Gender  needs to be male or female")
    public String gender;

    @DateTimeFormat(pattern = "dd MMM yyyy")
    @JsonFormat(pattern = "dd MMM yyyy",shape = JsonFormat.Shape.STRING)
    @NotNull(message = "Startdate should not be empty")
    @PastOrPresent(message = "startDate shuld be past or todays date")
    public Date startDate;

    @NotBlank(message = "Note can not be empty")
    public String note;

    @NotBlank(message = "profilePic can not be empty")
    public String profilePic;

    @NotNull(message = "department should not be empty")
    public List<String> departments;
}

