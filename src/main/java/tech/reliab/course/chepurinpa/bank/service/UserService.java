package tech.reliab.course.chepurinpa.bank.service;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    User createUser(Long userId,
                    String fullName,
                    LocalDate birthDate,
                    String workplace,
                    List<Bank> associatedBanks);

    User getUserById(Long userId);

    void updateUserById(Long userId);

    void deleteUserById(Long userId);
}