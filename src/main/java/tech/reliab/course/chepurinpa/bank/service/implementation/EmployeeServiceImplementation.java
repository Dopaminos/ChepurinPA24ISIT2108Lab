package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.BankOffice;
import tech.reliab.course.chepurinpa.bank.entity.Employee;
import tech.reliab.course.chepurinpa.bank.service.EmployeeService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class EmployeeServiceImplementation implements EmployeeService {

    private final Map<Long, Employee> employeeMap = new HashMap<>();

    @Override
    public Employee createEmployee(Long employeeId, String fullName, LocalDate birthDate, String jobTitle, Bank bank,
                                   Boolean isRemote, BankOffice bankOffice, Boolean canIssueLoans, Double salary) {
        Employee employee = Employee.builder()
                .employeeId(employeeId)
                .fullName(fullName)
                .birthDate(birthDate)
                .jobTitle(jobTitle)
                .bank(bank)
                .isRemote(isRemote)
                .bankOffice(bankOffice)
                .canIssueLoans(canIssueLoans)
                .salary(salary)
                .build();
        employeeMap.put(employeeId, employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeMap.get(employeeId);
    }

    @Override
    public void updateEmployeeById(Long employeeId, Employee employee) {
        if (employeeMap.containsKey(employeeId)) {
            employeeMap.put(employeeId, employee);
        } else {
            throw new IllegalArgumentException("Сотрудник с ID " + employeeId + " не существует.");
        }
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        if (employeeMap.containsKey(employeeId)) {
            employeeMap.remove(employeeId);
        } else {
            throw new IllegalArgumentException("Сотрудник с ID " + employeeId + " не существует.");
        }
    }
}