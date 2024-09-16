package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.*;
import tech.reliab.course.chepurinpa.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CreditAccountServiceImplementation implements CreditAccountService {

    private final Map<Long, CreditAccount> creditAccountMap = new HashMap<>();

    @Override
    public CreditAccount createCreditAccount(Long creditAccountId,
                                             User accountHolder,
                                             LocalDate startDate,
                                             LocalDate endDate,
                                             Integer creditDurationMonths,
                                             Double creditAmount,
                                             Double monthlyPayment,
                                             Double interestRate,
                                             Employee issuingEmployee,
                                             PaymentAccount linkedPaymentAccount,
                                             String bankName) {
        CreditAccount creditAccount = CreditAccount.builder()
                .creditAccountId(creditAccountId)
                .accountHolder(accountHolder)
                .startDate(startDate)
                .endDate(endDate)
                .creditDurationMonths(creditDurationMonths)
                .creditAmount(creditAmount)
                .monthlyPayment(monthlyPayment)
                .interestRate(interestRate)
                .issuingEmployee(issuingEmployee)
                .linkedPaymentAccount(linkedPaymentAccount)
                .bankName(bankName)
                .build();
        creditAccountMap.put(creditAccountId, creditAccount);
        return creditAccount;
    }

    @Override
    public CreditAccount getCreditAccountById(Long creditAccountId) {
        return creditAccountMap.get(creditAccountId);
    }

    @Override
    public void updateCreditAccountById(Long creditAccountId, CreditAccount creditAccount) {
        if (creditAccountMap.containsKey(creditAccountId)) {
            creditAccountMap.put(creditAccountId, creditAccount);
        } else {
            throw new IllegalArgumentException("Кредитный счёт с ID " + creditAccountId + " не существует.");
        }
    }

    @Override
    public void deleteCreditAccountById(Long creditAccountId) {
        if (creditAccountMap.containsKey(creditAccountId)) {
            creditAccountMap.remove(creditAccountId);
        } else {
            throw new IllegalArgumentException("Кредитный счёт с ID " + creditAccountId + " не существует.");
        }
    }
}