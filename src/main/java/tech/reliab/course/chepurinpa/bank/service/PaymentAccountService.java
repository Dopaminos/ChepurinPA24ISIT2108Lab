package tech.reliab.course.chepurinpa.bank.service;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.PaymentAccount;
import tech.reliab.course.chepurinpa.bank.entity.User;

public interface PaymentAccountService {

    PaymentAccount createPaymentAccount(Long id, User user, Bank bank);

    PaymentAccount getPaymentAccountById(Long id);


    void updatePaymentAccountById(Long id);

    void deletePaymentAccountById(Long id);
}
