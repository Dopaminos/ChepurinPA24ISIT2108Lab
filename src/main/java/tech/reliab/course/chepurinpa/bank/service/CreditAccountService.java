package tech.reliab.course.chepurinpa.bank.service;

import tech.reliab.course.chepurinpa.bank.entity.CreditAccount;
import tech.reliab.course.chepurinpa.bank.entity.Employee;
import tech.reliab.course.chepurinpa.bank.entity.PaymentAccount;
import tech.reliab.course.chepurinpa.bank.entity.User;

import java.time.LocalDate;

public interface CreditAccountService {

    CreditAccount createCreditAccount(Long creditAccountId,
                                      User accountHolder,
                                      LocalDate startDate,
                                      LocalDate endDate,
                                      Integer creditDurationMonths,
                                      Double creditAmount,
                                      Double monthlyPayment,
                                      Double interestRate,
                                      Employee issuingEmployee,
                                      PaymentAccount linkedPaymentAccount,
                                      String bankName);

    CreditAccount getCreditAccountById(Long creditAccountId);

    void updateCreditAccountById(Long creditAccountId, CreditAccount creditAccount);

    void deleteCreditAccountById(Long creditAccountId);
}