package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.service.BankService;

import java.util.HashMap;
import java.util.Map;

public class BankServiceImplementation implements BankService {

    private final Map<Long, Bank> bankMap = new HashMap<>();

    @Override
    public Bank createBank(Long bankId, String bankName) {
        Bank bank = Bank.builder()
                .bankId(bankId)
                .bankName(bankName)
                .build();
        bankMap.put(bankId, bank);
        return bank;
    }

    @Override
    public Bank getBankById(Long bankId) {
        return bankMap.get(bankId);
    }

    @Override
    public void updateBankById(Long bankId, Bank bank) {
        if (bankMap.containsKey(bankId)) {
            bankMap.put(bankId, bank);
        } else {
            throw new IllegalArgumentException("Банк с ID " + bankId + " не существует.");
        }
    }

    @Override
    public void deleteBankById(Long bankId) {
        if (bankMap.containsKey(bankId)) {
            bankMap.remove(bankId);
        } else {
            throw new IllegalArgumentException("Банк с ID " + bankId + " не существует.");
        }
    }
}