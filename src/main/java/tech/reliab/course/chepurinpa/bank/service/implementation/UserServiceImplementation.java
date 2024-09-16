package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.User;
import tech.reliab.course.chepurinpa.bank.service.UserService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImplementation implements UserService {

    private final Map<Long, User> userMap = new HashMap<>();

    @Override
    public User createUser(Long userId,
                           String fullName,
                           LocalDate birthDate,
                           String workplace,
                           Double monthlyIncome,
                           List<Bank> associatedBanks) {
        User user = User.builder()
                .userId(userId)
                .fullName(fullName)
                .birthDate(birthDate)
                .workplace(workplace)
                .monthlyIncome(monthlyIncome)
                .associatedBanks(associatedBanks)
                .build();
        userMap.put(userId, user);
        return user;
    }

    @Override
    public User getUserById(Long userId) {
        return userMap.get(userId);
    }

    @Override
    public void updateUserById(Long userId, User user) {
        if (userMap.containsKey(userId)) {
            userMap.put(userId, user);
        } else {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не существует.");
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        if (userMap.containsKey(userId)) {
            userMap.remove(userId);
        } else {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не существует.");
        }
    }
}