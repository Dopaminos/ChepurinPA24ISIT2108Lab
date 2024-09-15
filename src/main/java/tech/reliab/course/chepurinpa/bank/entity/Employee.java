package tech.reliab.course.chepurinpa.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
public class Employee {

    private Long employeeId;
    private String fullName;
    private LocalDate birthDate;
    private String jobTitle;
    private Bank bank;
    private Boolean isRemote;
    private BankOffice bankOffice;
    private Boolean canIssueLoans;
    private Double salary;

    @Override
    public String toString() {
        return "Employee {" +
                "\nemployeeId=" + employeeId +
                ", \nfullName='" + fullName + '\'' +
                ", \nbirthDate=" + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", \njobTitle='" + jobTitle + '\'' +
                ", \nbankId=" + bank.getBankId() +
                ", \nisRemote=" + isRemote +
                ", \nbankOfficeId=" + bankOffice.getOfficeId() +
                ", \ncanIssueLoans=" + canIssueLoans +
                ", \nsalary=" + salary +
                "\n}";
    }
}