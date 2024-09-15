package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.PaymentAccount;
import tech.reliab.course.chepurinpa.bank.entity.User;
import tech.reliab.course.chepurinpa.bank.service.PaymentAccountService;

public class PaymentAccountServiceImplementation implements PaymentAccountService {

    @Override
    public PaymentAccount createPaymentAccount(Long paymentAccountId, User accountHolder, Bank bank) {
        PaymentAccount paymentAccount = PaymentAccount.builder()
                .paymentAccountId(paymentAccountId)
                .accountHolder(accountHolder)
                .bankName(bank.getBankName())
                .balance(0.0)
                .build();

        accountHolder.getPaymentAccounts().add(paymentAccount);
        return paymentAccount;
    }

    @Override
    public PaymentAccount getPaymentAccountById(Long paymentAccountId) {
        return null;
    }

    @Override
    public void updatePaymentAccountById(Long paymentAccountId) {}

    @Override
    public void deletePaymentAccountById(Long paymentAccountId) {}
}