package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.*;
import tech.reliab.course.chepurinpa.bank.service.CreditAccountService;

import java.time.LocalDate;

public class CreditAccountServiceImplementation implements CreditAccountService {

    @Override
    public CreditAccount createCreditAccount(Long creditAccountId,
                                             User accountHolder,
                                             LocalDate startDate,
                                             LocalDate endDate,
                                             Integer creditDurationMonths,
                                             Double creditAmount,
                                             Double monthlyPayment,
                                             Employee issuingEmployee,
                                             PaymentAccount linkedPaymentAccount,
                                             Bank bank) {
        CreditAccount creditAccount = CreditAccount.builder()
                .creditAccountId(creditAccountId)
                .accountHolder(accountHolder)
                .bankName(bank.getBankName())
                .startDate(startDate)
                .endDate(endDate)
                .creditDurationMonths(creditDurationMonths)
                .creditAmount(creditAmount)
                .monthlyPayment(monthlyPayment)
                .interestRate(bank.getInterestRate())
                .issuingEmployee(issuingEmployee)
                .linkedPaymentAccount(linkedPaymentAccount)
                .build();
        accountHolder.getCreditAccounts().add(creditAccount);
        return creditAccount;
    }

    @Override
    public CreditAccount getCreditAccountById(Long creditAccountId) {
        return null;
    }

    @Override
    public void updateCreditAccountById(Long creditAccountId) {}

    @Override
    public void deleteCreditAccountById(Long creditAccountId) {}
}