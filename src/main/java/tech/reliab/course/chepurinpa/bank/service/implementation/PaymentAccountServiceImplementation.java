package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.PaymentAccount;
import tech.reliab.course.chepurinpa.bank.entity.User;
import tech.reliab.course.chepurinpa.bank.service.PaymentAccountService;

import java.util.HashMap;
import java.util.Map;

public class PaymentAccountServiceImplementation implements PaymentAccountService {

    private final Map<Long, PaymentAccount> paymentAccountMap = new HashMap<>();

    @Override
    public PaymentAccount createPaymentAccount(Long paymentAccountId,
                                               User accountHolder,
                                               String bankName,
                                               Double balance) {
        PaymentAccount paymentAccount = PaymentAccount.builder()
                .paymentAccountId(paymentAccountId)
                .accountHolder(accountHolder)
                .bankName(bankName)
                .balance(balance)
                .build();
        paymentAccountMap.put(paymentAccountId, paymentAccount);
        return paymentAccount;
    }

    @Override
    public PaymentAccount getPaymentAccountById(Long paymentAccountId) {
        return paymentAccountMap.get(paymentAccountId);
    }

    @Override
    public void updatePaymentAccountById(Long paymentAccountId, PaymentAccount paymentAccount) {
        if (paymentAccountMap.containsKey(paymentAccountId)) {
            paymentAccountMap.put(paymentAccountId, paymentAccount);
        } else {
            throw new IllegalArgumentException("Платёжный счёт с ID " + paymentAccountId + " не существует.");
        }
    }

    @Override
    public void deletePaymentAccountById(Long paymentAccountId) {
        if (paymentAccountMap.containsKey(paymentAccountId)) {
            paymentAccountMap.remove(paymentAccountId);
        } else {
            throw new IllegalArgumentException("Платёжный счёт с ID " + paymentAccountId + " не существует.");
        }
    }
}