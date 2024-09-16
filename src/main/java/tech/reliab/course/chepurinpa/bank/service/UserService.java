package tech.reliab.course.chepurinpa.bank.service;
import tech.reliab.course.chepurinpa.bank.entity.User;
import tech.reliab.course.chepurinpa.bank.entity.Bank;
import java.time.LocalDate;
import java.util.List;

public interface UserService {

    User createUser(Long userId,
                    String fullName,
                    LocalDate birthDate,
                    String workplace,
                    Double monthlyIncome,
                    List<Bank> associatedBanks);

    User getUserById(Long userId);

    void updateUserById(Long userId, User user);

    void deleteUserById(Long userId);
}