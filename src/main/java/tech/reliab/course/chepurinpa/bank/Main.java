package tech.reliab.course.chepurinpa.bank;

import tech.reliab.course.chepurinpa.bank.utils.EntitiesInitializer;

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
            System.out.println("5. Выход [<-]");

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
                    return;
                }
                default -> System.out.println("Неправильный выбор. Попробуйте ещё раз.");
            }
        }
    }
}