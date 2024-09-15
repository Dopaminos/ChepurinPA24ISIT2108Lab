package tech.reliab.course.chepurinpa.bank.service;

import tech.reliab.course.chepurinpa.bank.entity.*;

import java.time.LocalDate;

public interface CreditAccountService {

    CreditAccount createCreditAccount(Long creditAccountId,
                                      User accountHolder,
                                      LocalDate startDate,
                                      LocalDate endDate,
                                      Integer creditDurationMonths,
                                      Double creditAmount,
                                      Double monthlyPayment,
                                      Employee issuingEmployee,
                                      PaymentAccount linkedPaymentAccount,
                                      Bank bank);

    CreditAccount getCreditAccountById(Long creditAccountId);

    void updateCreditAccountById(Long creditAccountId);

    void deleteCreditAccountById(Long creditAccountId);
}