package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.BankOffice;
import tech.reliab.course.chepurinpa.bank.service.BankOfficeService;

import java.util.HashMap;
import java.util.Map;

public class BankOfficeServiceImplementation implements BankOfficeService {

    private final Map<Long, BankOffice> bankOfficeMap = new HashMap<>();

    @Override
    public BankOffice createBankOffice(Long officeId, String officeName, String officeAddress, Boolean isOperational,
                                       Boolean canHostAtm, Integer atmCount, Boolean canIssueLoans, Boolean canDispenseCash,
                                       Boolean canAcceptCash, Double officeFunds, Double rentalCost, Bank bank) {
        BankOffice bankOffice = BankOffice.builder()
                .officeId(officeId)
                .officeName(officeName)
                .officeAddress(officeAddress)
                .isOperational(isOperational)
                .canHostAtm(canHostAtm)
                .atmCount(atmCount)
                .canIssueLoans(canIssueLoans)
                .canDispenseCash(canDispenseCash)
                .canAcceptCash(canAcceptCash)
                .officeFunds(officeFunds)
                .rentalCost(rentalCost)
                .bank(bank)
                .build();
        bankOfficeMap.put(officeId, bankOffice);
        return bankOffice;
    }

    @Override
    public BankOffice getBankOfficeById(Long officeId) {
        return bankOfficeMap.get(officeId);
    }

    @Override
    public void updateBankOfficeById(Long officeId, BankOffice bankOffice) {
        if (bankOfficeMap.containsKey(officeId)) {
            bankOfficeMap.put(officeId, bankOffice);
        } else {
            throw new IllegalArgumentException("Офис с ID " + officeId + " не существует.");
        }
    }

    @Override
    public void deleteBankOfficeById(Long officeId) {
        if (bankOfficeMap.containsKey(officeId)) {
            bankOfficeMap.remove(officeId);
        } else {
            throw new IllegalArgumentException("Офис с ID " + officeId + " не существует.");
        }
    }
}