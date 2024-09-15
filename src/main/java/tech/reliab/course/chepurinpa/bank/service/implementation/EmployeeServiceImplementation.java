package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.BankOffice;
import tech.reliab.course.chepurinpa.bank.entity.Employee;
import tech.reliab.course.chepurinpa.bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImplementation implements EmployeeService {

    @Override
    public Employee createEmployee(Long employeeId,
                                   String fullName,
                                   LocalDate birthDate,
                                   String jobTitle,
                                   Bank bank,
                                   Boolean isRemote,
                                   BankOffice bankOffice,
                                   Boolean canIssueLoans,
                                   Double salary) {
        bank.setEmployeeCount(bank.getEmployeeCount() + 1);
        return Employee.builder()
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
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return null;
    }

    @Override
    public void updateEmployeeById(Long employeeId) {}

    @Override
    public void deleteEmployeeById(Long employeeId) {}
}