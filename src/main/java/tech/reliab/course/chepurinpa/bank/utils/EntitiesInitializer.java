package tech.reliab.course.chepurinpa.bank.utils;

import tech.reliab.course.chepurinpa.bank.entity.*;
import tech.reliab.course.chepurinpa.bank.service.*;
import tech.reliab.course.chepurinpa.bank.service.implementation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
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
    private final String[] firstNames = {"Иван", "Петр", "Сергей", "Алексей", "Дмитрий"};
    private final String[] lastNames = {"Иванов", "Петров", "Сидоров", "Смирнов", "Кузнецов"};
    private final String[] middleNames = {"Иванович", "Петрович", "Сергеевич", "Алексеевич", "Дмитриевич"};
    private final String[] jobTitles = {"Менеджер", "Консультант", "Кассир", "Охранник", "Уборщик"};
    private final String[] workplaces = {"Пятерочка", "Магнит", "Лента", "Озон", "Вайлдберриз"};
    private final String[] bankNames = {"Сбербанк", "ВТБ", "Газпромбанк", "Альфа-Банк", "Тинькофф"};
    private final String[] streetNames = {"Ленина", "Советская", "Мира", "Пушкина", "Гагарина"};

    public void initializeEntities() {
        for (int i = 1; i <= 5; i++) {
            Bank bank = generateBank(i);
            bankList.add(bank);

            for (int j = 1; j <= 3; j++) {
                BankOffice bankOffice = generateBankOffice(bank, j);
                bankOfficeList.add(bankOffice);

                for (int k = 1; k <= 5; k++) {
                    Employee employee = generateEmployee(bank, bankOffice, k);
                    employeeList.add(employee);
                }

                for (int l = 1; l <= 3; l++) {
                    BankAtm bankAtm = generateBankAtm(bank, bankOffice, l);
                    bankAtmList.add(bankAtm);
                }
            }

            for (int m = 1; m <= 5; m++) {
                User user = generateUser(bank, m);
                userList.add(user);

                for (int n = 1; n <= 2; n++) {
                    PaymentAccount paymentAccount = generatePaymentAccount(user, bank, n);
                    paymentAccountList.add(paymentAccount);

                    CreditAccount creditAccount = generateCreditAccount(user, employeeList.get(random.nextInt(employeeList.size())), paymentAccount, bank, n);
                    creditAccountList.add(creditAccount);
                }
            }
        }
    }

    private Bank generateBank(int orderNumber) {
        return bankService.createBank(
                (long) orderNumber,
                bankNames[orderNumber - 1]
        );
    }

    private BankOffice generateBankOffice(Bank bank, int orderNumber) {
        return bankOfficeService.createBankOffice(
                (long) orderNumber,
                bank.getBankName() + " офис " + orderNumber,
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
                bank.getBankName() + " ATM " + orderNumber,
                "Operational",
                bank,
                bankOffice,
                employeeList.get(random.nextInt(employeeList.size())),
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
                jobTitles[random.nextInt(jobTitles.length)],
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
                List.of(bank)
        );
    }

    private PaymentAccount generatePaymentAccount(User user, Bank bank, int orderNumber) {
        return paymentAccountService.createPaymentAccount(
                (long) orderNumber,
                user,
                bank
        );
    }

    private CreditAccount generateCreditAccount(User user, Employee employee, PaymentAccount paymentAccount, Bank bank, int orderNumber) {
        return creditAccountService.createCreditAccount(
                (long) orderNumber,
                user,
                LocalDate.now(),
                LocalDate.now(),
                orderNumber * 2,
                (double) orderNumber * 10,
                (double) orderNumber * 5,
                employee,
                paymentAccount,
                bank
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
}