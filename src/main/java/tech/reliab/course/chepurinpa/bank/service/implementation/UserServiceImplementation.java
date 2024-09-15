package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.User;
import tech.reliab.course.chepurinpa.bank.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserServiceImplementation implements UserService {

    @Override
    public User createUser(Long userId,
                           String fullName,
                           LocalDate birthDate,
                           String workplace,
                           List<Bank> associatedBanks) {
        Random random = new Random();
        User user = User.builder()
                .userId(userId)
                .fullName(fullName)
                .birthDate(birthDate)
                .workplace(workplace)
                .monthlyIncome(Math.round(random.nextDouble(10_000) * 100.0) / 100.0)
                .associatedBanks(associatedBanks)
                .creditAccounts(new ArrayList<>())
                .paymentAccounts(new ArrayList<>())
                .build();
        user.setCreditRating(switch ((int) (user.getMonthlyIncome() / 1000)) {
            case 2 -> 200;
            case 3 -> 300;
            case 4 -> 400;
            case 5 -> 500;
            case 6 -> 600;
            case 7 -> 700;
            case 8 -> 800;
            case 9 -> 900;
            case 10 -> 1000;
            default -> 100;
        });
        associatedBanks.forEach(bank -> bank.setCustomerCount(bank.getCustomerCount() + 1));
        return user;
    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }

    @Override
    public void updateUserById(Long userId) {}

    @Override
    public void deleteUserById(Long userId) {}
}