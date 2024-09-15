package tech.reliab.course.chepurinpa.bank;
import tech.reliab.course.chepurinpa.bank.utils.EntitiesInitializer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EntitiesInitializer initializer = new EntitiesInitializer();
        initializer.initializeEntities();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select detail info:");
            System.out.println("1 Offices list");
            System.out.println("2 Employees list");
            System.out.println("3 ATMs list");
            System.out.println("4 Users list");
            System.out.println("5 Exit <-");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> initializer.bankOfficeList.forEach(System.out::println);
                case 2 -> initializer.employeeList.forEach(System.out::println);
                case 3 -> initializer.bankAtmList.forEach(System.out::println);
                case 4 -> initializer.userList.forEach(user -> {
                    System.out.println(user);
                    System.out.println("Payment Accounts:");
                    user.getPaymentAccounts().forEach(System.out::println);
                    System.out.println("Credit Accounts:");
                    user.getCreditAccounts().forEach(System.out::println);
                });
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}