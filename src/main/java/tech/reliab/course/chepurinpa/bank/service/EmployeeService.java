package tech.reliab.course.chepurinpa.bank.service;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.BankOffice;
import tech.reliab.course.chepurinpa.bank.entity.Employee;

import java.time.LocalDate;

public interface EmployeeService {

    Employee createEmployee(Long employeeId,
                            String fullName,
                            LocalDate birthDate,
                            String jobTitle,
                            Bank bank,
                            Boolean isRemote,
                            BankOffice bankOffice,
                            Boolean canIssueLoans,
                            Double salary);

    Employee getEmployeeById(Long employeeId);

    void updateEmployeeById(Long employeeId, Employee employee);

    void deleteEmployeeById(Long employeeId);
}