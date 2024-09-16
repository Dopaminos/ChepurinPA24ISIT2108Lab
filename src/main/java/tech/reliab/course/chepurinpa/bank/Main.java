package tech.reliab.course.chepurinpa.bank;

import tech.reliab.course.chepurinpa.bank.entity.*;
import tech.reliab.course.chepurinpa.bank.exception.*;
import tech.reliab.course.chepurinpa.bank.utils.EntitiesInitializer;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EntitiesInitializer initializer = new EntitiesInitializer();
        initializer.initializeEntities();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите информацию для вывода:");
            System.out.println("1. Список офисов");
            System.out.println("2. Список сотрудников");
            System.out.println("3. Список банкоматов");
            System.out.println("4. Список пользователей");
            System.out.println("5. Получить кредит");
            System.out.println("6. Выход [<-]");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> initializer.bankOfficeList.forEach(System.out::println);
                case 2 -> initializer.employeeList.forEach(System.out::println);
                case 3 -> initializer.bankAtmList.forEach(System.out::println);
                case 4 -> initializer.userList.forEach(user -> {
                    System.out.println(user);
                    System.out.println("Платёжные счета:");
                    user.getPaymentAccounts().forEach(System.out::println);
                    System.out.println("Кредитные счета:");
                    user.getCreditAccounts().forEach(System.out::println);
                });
                case 5 -> {
                    System.out.println("Выберите клиента по его номеру:");
                    for (int i = 0; i < initializer.userList.size(); i++) {
                        System.out.println((i + 1) + ". " + initializer.userList.get(i).getFullName());
                    }
                    int userIndex = scanner.nextInt() - 1;
                    if (userIndex < 0 || userIndex >= initializer.userList.size()) {
                        System.out.println("Неправильный выбор. Попробуйте ещё раз.");
                        break;
                    }
                    User user = initializer.userList.get(userIndex);
                    System.out.println("Введите запрашиваемую сумму кредита:");
                    double requestedAmount = scanner.nextDouble();
                    try {
                        processCreditRequest(initializer, user, requestedAmount);
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }
                case 6 -> {
                    return;
                }
                default -> System.out.println("Неправильный выбор. Попробуйте ещё раз.");
            }
        }
    }

    private static void processCreditRequest(EntitiesInitializer initializer, User user, double requestedAmount) throws Exception {
        System.out.println("Поиск лучшего банка...");
        Optional<Bank> bankOpt = initializer.findBestBank();
        if (bankOpt.isEmpty()) {
            throw new BankNotFoundException();
        }
        Bank bank = bankOpt.get();
        System.out.println("Найден банк: " + bank.getBankName());

        System.out.println("Поиск подходящего офиса...");
        Optional<BankOffice> officeOpt = initializer.findSuitableOffice(bank, requestedAmount);
        if (officeOpt.isEmpty()) {
            throw new OfficeNotFoundException();
        }
        BankOffice office = officeOpt.get();
        System.out.println("Найден офис: " + office.getOfficeName());

        System.out.println("Поиск подходящего сотрудника...");
        Optional<Employee> employeeOpt = initializer.findSuitableEmployee(office);
        if (employeeOpt.isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        Employee employee = employeeOpt.get();
        System.out.println("Найден сотрудник: " + employee.getFullName());

        if (user.getCreditRating() < 5000 && bank.getBankRating() > 50) {
            throw new InsufficientCreditRatingException();
        }

        if (user.getPaymentAccounts().stream().noneMatch(account -> account.getBank().equals(bank))) {
            System.out.println("Создание нового платёжного счёта...");
            PaymentAccount newAccount = initializer.generatePaymentAccount(user, bank, user.getPaymentAccounts().size() + 1);
            user.getPaymentAccounts().add(newAccount);
            initializer.paymentAccountList.add(newAccount);
            System.out.println("Создан новый платёжный счёт: " + newAccount.getPaymentAccountId());
        }

        System.out.println("Поиск подходящего банкомата...");
        Optional<BankAtm> atmOpt = initializer.findSuitableAtm(office, requestedAmount);
        if (atmOpt.isEmpty()) {
            throw new AtmNotFoundException();
        }
        BankAtm atm = atmOpt.get();
        System.out.println("Найден банкомат: " + atm.getAtmId());

        System.out.println("Создание кредитного счёта...");
        CreditAccount creditAccount = initializer.generateCreditAccount(user, employee, user.getPaymentAccounts().getFirst(), bank, user.getCreditAccounts().size() + 1);
        user.getCreditAccounts().add(creditAccount);
        initializer.creditAccountList.add(creditAccount);
        System.out.println("Кредит успешно выдан.");
    }
}