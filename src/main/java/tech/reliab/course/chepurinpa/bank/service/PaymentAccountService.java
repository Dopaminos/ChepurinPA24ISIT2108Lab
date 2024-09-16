package tech.reliab.course.chepurinpa.bank.service;

import tech.reliab.course.chepurinpa.bank.entity.PaymentAccount;
import tech.reliab.course.chepurinpa.bank.entity.User;

public interface PaymentAccountService {

    PaymentAccount createPaymentAccount(Long paymentAccountId, User accountHolder, String bankName, Double balance);

    PaymentAccount getPaymentAccountById(Long paymentAccountId);

    void updatePaymentAccountById(Long paymentAccountId, PaymentAccount paymentAccount);

    void deletePaymentAccountById(Long paymentAccountId);
}