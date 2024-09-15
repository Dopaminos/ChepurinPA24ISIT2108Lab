package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.service.BankService;

import java.util.Random;

public class BankServiceImplementation implements BankService {

    @Override
    public Bank createBank(Long bankId, String bankName) {
        Random random = new Random();
        Bank bank = Bank.builder()
                .bankId(bankId)
                .bankName(bankName)
                .officeCount(0)
                .atmCount(0)
                .employeeCount(0)
                .customerCount(0)
                .bankRating(random.nextInt(101))
                .totalFunds(Math.round(random.nextDouble(1_000_000) * 100.0) / 100.0)
                .build();
        bank.setInterestRate(Math.round((20 - bank.getBankRating() * 0.2) * 100.0) / 100.0);
        return bank;
    }

    @Override
    public Bank getBankById(Long bankId) {
        return null;
    }

    @Override
    public void updateBankById(Long bankId, Bank bank) {
    }

    @Override
    public void deleteBankById(Long bankId, Bank bank) {
    }
}