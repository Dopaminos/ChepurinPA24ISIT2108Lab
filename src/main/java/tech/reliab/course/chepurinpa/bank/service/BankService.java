package tech.reliab.course.chepurinpa.bank.service;

import tech.reliab.course.chepurinpa.bank.entity.Bank;

public interface BankService {

    Bank createBank(Long bankId, String bankName, Integer bankRating);

    Bank getBankById(Long bankId);

    void updateBankById(Long bankId, Bank bank);

    void deleteBankById(Long bankId);
}