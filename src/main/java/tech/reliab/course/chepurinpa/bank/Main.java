package tech.reliab.course.chepurinpa.bank;

import tech.reliab.course.chepurinpa.bank.entity.*;
import tech.reliab.course.chepurinpa.bank.service.*;
import tech.reliab.course.chepurinpa.bank.service.implementation.*;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BankService bankService = new BankServiceImplementation();
        BankAtmService bankAtmService = new BankAtmServiceImplementation();
        BankOfficeService bankOfficeService = new BankOfficeServiceImplementation();
        CreditAccountService creditAccountService = new CreditAccountServiceImplementation();
        EmployeeService employeeService = new EmployeeServiceImplementation();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImplementation();
        UserService userService = new UserServiceImplementation();

        Bank bank = bankService.createBank(1L, "Sberbank");
        BankOffice bankOffice = bankOfficeService.createBankOffice(
                1L, "Sberbank Office #2", "Petrovskaya, 11", true, true, 0, true, true, true, 1.0, 1.0, bank);
        Employee employee = employeeService.createEmployee(
                1L, "Ivanov Ivan Ivanovich", LocalDate.now(), "Manager", bank, true, bankOffice, true, 1.0);
        BankAtm bankAtm = bankAtmService.createBankAtm(
                1L, "Sberbank ATM #4", "Working", bank, bankOffice, employee, true, true, 1.0, 1.0);
        User user = userService.createUser(
                1L, "Ivanov Ivan Ivanovich", LocalDate.now(), "Pyaterochka", List.of(bank));
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(1L, user, bank);
        CreditAccount creditAccount = creditAccountService.createCreditAccount(
                1L, user, LocalDate.now(), LocalDate.now(), 1, 1.0, 1.0, employee, paymentAccount, bank);

        System.out.println(bank);
        System.out.println();
        System.out.println(bankAtm);
        System.out.println();
        System.out.println(bankOffice);
        System.out.println();
        System.out.println(creditAccount);
        System.out.println();
        System.out.println(employee);
        System.out.println();
        System.out.println(paymentAccount);
        System.out.println();
        System.out.println(user);
    }
}