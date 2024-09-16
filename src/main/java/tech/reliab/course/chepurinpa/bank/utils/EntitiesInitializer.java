package tech.reliab.course.chepurinpa.bank.utils;

import tech.reliab.course.chepurinpa.bank.entity.*;
import tech.reliab.course.chepurinpa.bank.service.*;
import tech.reliab.course.chepurinpa.bank.service.implementation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class EntitiesInitializer {

    private final BankService bankService = new BankServiceImplementation();
    private final BankAtmService bankAtmService = new BankAtmServiceImplementation();
    private final BankOfficeService bankOfficeService = new BankOfficeServiceImplementation();
    private final CreditAccountService creditAccountService = new CreditAccountServiceImplementation();
    private final EmployeeService employeeService = new EmployeeServiceImplementation();
    private final PaymentAccountService paymentAccountService = new PaymentAccountServiceImplementation();
    private final UserService userService = new UserServiceImplementation();

    public final List<Bank> bankList = new ArrayList<>();
    public final List<BankOffice> bankOfficeList = new ArrayList<>();
    public final List<Employee> employeeList = new ArrayList<>();
    public final List<BankAtm> bankAtmList = new ArrayList<>();
    public final List<User> userList = new ArrayList<>();
    public final List<PaymentAccount> paymentAccountList = new ArrayList<>();
    public final List<CreditAccount> creditAccountList = new ArrayList<>();

    private final Random random = new Random();
    private final String[] bankNames = {"Сбербанк", "ВТБ", "Альфа-Банк", "Тинькофф", "Газпромбанк"};
    private final String[] streetNames = {"Ленина", "Пушкина", "Гагарина", "Мира", "Советская"};
    private final String[] lastNames = {"Иванов", "Петров", "Сидоров", "Кузнецов", "Смирнов"};
    private final String[] firstNames = {"Алексей", "Дмитрий", "Иван", "Сергей", "Андрей"};
    private final String[] middleNames = {"Алексеевич", "Дмитриевич", "Иванович", "Сергеевич", "Андреевич"};
    private final String[] workplaces = {"ООО Ромашка", "ЗАО Лотос", "ИП Иванов", "АО Альфа", "ПАО Сбербанк"};

    public void initializeEntities() {
        for (int i = 1; i <= bankNames.length; i++) {
            Bank bank = generateBank(i);
            bankList.add(bank);

            List<BankOffice> bankOffices = new ArrayList<>();
            for (int j = 1; j <= 3; j++) {
                BankOffice bankOffice = generateBankOffice(bank, j);
                bankOfficeList.add(bankOffice);
                bankOffices.add(bankOffice);

                List<BankAtm> officeAtms = new ArrayList<>();
                for (int k = 1; k <= 2; k++) {
                    BankAtm bankAtm = generateBankAtm(bank, bankOffice, k);
                    bankAtmList.add(bankAtm);
                    officeAtms.add(bankAtm);
                }
                bankOffice.setAtms(officeAtms);
            }
            bank.setOffices(bankOffices);

            List<Employee> bankEmployees = new ArrayList<>();
            for (int l = 1; l <= 5; l++) {
                Employee employee = generateEmployee(bank, bankOffices.get(random.nextInt(bankOffices.size())), l);
                employeeList.add(employee);
                bankEmployees.add(employee);
            }
            bank.setEmployees(bankEmployees);

            for (int m = 1; m <= 5; m++) {
                User user = generateUser(bank, m);
                userList.add(user);

                List<PaymentAccount> userPaymentAccounts = new ArrayList<>();
                List<CreditAccount> userCreditAccounts = new ArrayList<>();

                for (int n = 1; n <= 2; n++) {
                    PaymentAccount paymentAccount = generatePaymentAccount(user, bank, n);
                    paymentAccountList.add(paymentAccount);
                    userPaymentAccounts.add(paymentAccount);

                    CreditAccount creditAccount = generateCreditAccount(user,
                            employeeList.get(random.nextInt(employeeList.size())),
                            paymentAccount,
                            bank,
                            n);
                    creditAccountList.add(creditAccount);
                    userCreditAccounts.add(creditAccount);
                }

                user.setPaymentAccounts(userPaymentAccounts);
                user.setCreditAccounts(userCreditAccounts);

                // Установка кредитного рейтинга
                user.setCreditRating(generateCreditRating(user.getMonthlyIncome()));
            }
        }
    }

    private Bank generateBank(int orderNumber) {
        return bankService.createBank(
                (long) orderNumber,
                bankNames[orderNumber - 1],
                random.nextInt(100)
        );
    }

    private BankOffice generateBankOffice(Bank bank, int orderNumber) {
        return bankOfficeService.createBankOffice(
                (long) orderNumber,
                bank.getBankName() + ", Офис " + orderNumber,
                streetNames[orderNumber - 1] + ", " + orderNumber,
                true,
                true,
                0,
                true,
                true,
                true,
                (double) orderNumber * 10,
                (double) orderNumber * 5,
                bank
        );
    }

    private BankAtm generateBankAtm(Bank bank, BankOffice bankOffice, int orderNumber) {
        return bankAtmService.createBankAtm(
                random.nextLong(),
                bank.getBankName() + ", Банкомат " + orderNumber,
                "Работает",
                bank,
                bankOffice,
                employeeList.isEmpty() ? null : employeeList.get(random.nextInt(employeeList.size())),
                true,
                true,
                (double) orderNumber * 1000,
                (double) orderNumber * 100
        );
    }

    private Employee generateEmployee(Bank bank, BankOffice bankOffice, int orderNumber) {
        return employeeService.createEmployee(
                (long) orderNumber,
                getGeneratedFullName(),
                getRandomBirthDate(),
                "Сотрудник",
                bank,
                true,
                bankOffice,
                true,
                (double) orderNumber * 1000
        );
    }

    private User generateUser(Bank bank, int orderNumber) {
        return userService.createUser(
                (long) orderNumber,
                getGeneratedFullName(),
                LocalDate.now(),
                workplaces[random.nextInt(workplaces.length)],
                (double) (random.nextInt(100000) + 30000),
                List.of(bank)
        );
    }

    public PaymentAccount generatePaymentAccount(User user, Bank bank, int orderNumber) {
        return paymentAccountService.createPaymentAccount(
                (long) orderNumber,
                user,
                bank.getBankName(),
                (double) (random.nextInt(100000) + 10000),
                bank
        );
    }

    public CreditAccount generateCreditAccount(User user,
                                               Employee employee,
                                               PaymentAccount paymentAccount,
                                               Bank bank,
                                               int orderNumber) {
        return creditAccountService.createCreditAccount(
                (long) orderNumber,
                user,
                LocalDate.now(),
                LocalDate.now().plusYears(1),
                orderNumber * 12,
                (double) orderNumber * 100000,
                (double) orderNumber * 10000,
                15.0,
                employee,
                paymentAccount,
                bank.getBankName()
        );
    }

    private String getGeneratedFullName() {
        return lastNames[random.nextInt(lastNames.length)] + " " +
                firstNames[random.nextInt(firstNames.length)] + " " +
                middleNames[random.nextInt(middleNames.length)];
    }

    private LocalDate getRandomBirthDate() {
        int age = 20 + random.nextInt(15);
        return LocalDate.now().minus(Period.ofYears(age));
    }

    private Integer generateCreditRating(Double monthlyIncome) {
        return (int) (monthlyIncome / 1000) * 100;
    }

    public Optional<Bank> findBestBank() {
        System.out.println("Поиск лучшего банка...");
        return bankList.stream()
                .filter(bank -> {
                    if (bank.getAtms() == null || bank.getEmployees() == null || bank.getOffices() == null) {
                        System.out.println("Ошибка: один из параметров банка равен null");
                        return false;
                    }
                    return true;
                })
                .min(Comparator.comparingInt((Bank b) -> b.getAtms().size())
                        .thenComparingInt(b -> b.getEmployees().size())
                        .thenComparingInt(b -> b.getOffices().size())
                        .thenComparingDouble(b -> b.getInterestRate() != null ? b.getInterestRate() : Double.MAX_VALUE));
    }

    public Optional<BankOffice> findSuitableOffice(Bank bank, double requestedAmount) {
        System.out.println("Поиск подходящего офиса...");
        return bank.getOffices().stream()
                .filter(office -> {
                    System.out.println("Проверка офиса: " + office.getOfficeName());
                    System.out.println("Офис работает: " + office.getIsOperational());
                    System.out.println("Офис может выдавать кредиты: " + office.getCanIssueLoans());
                    System.out.println("Средства офиса: " + office.getOfficeFunds());
                    System.out.println("Запрашиваемая сумма: " + requestedAmount);
                    return office.getIsOperational() &&
                            office.getCanIssueLoans() &&
                            office.getOfficeFunds() >= requestedAmount;
                })
                .findFirst();
    }

    public Optional<Employee> findSuitableEmployee(BankOffice office) {
        System.out.println("Поиск подходящего сотрудника...");
        return office.getBank().getEmployees().stream()
                .filter(employee -> {
                    System.out.println("Проверка сотрудника: " + employee.getFullName());
                    System.out.println("Может выдавать кредиты: " + employee.getCanIssueLoans());
                    return employee.getCanIssueLoans();
                })
                .findFirst();
    }

    public Optional<BankAtm> findSuitableAtm(BankOffice office, double requestedAmount) {
        System.out.println("Поиск подходящего банкомата...");
        return office.getAtms().stream()
                .filter(atm -> {
                    System.out.println("Проверка банкомата: " + atm.getAtmId());
                    return atm.getAtmFunds() >= requestedAmount;
                })
                .findFirst();
    }
}