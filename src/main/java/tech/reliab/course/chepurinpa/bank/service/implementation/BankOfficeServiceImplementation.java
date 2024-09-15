package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.BankOffice;
import tech.reliab.course.chepurinpa.bank.service.BankOfficeService;

public class BankOfficeServiceImplementation implements BankOfficeService {

    @Override
    public BankOffice createBankOffice(Long officeId,
                                       String officeName,
                                       String officeAddress,
                                       Boolean isOperational,
                                       Boolean canHostAtm,
                                       Integer atmCount,
                                       Boolean canIssueLoans,
                                       Boolean canDispenseCash,
                                       Boolean canAcceptCash,
                                       Double officeFunds,
                                       Double rentalCost,
                                       Bank bank) {
        BankOffice bankOffice = BankOffice
                .builder()
                .officeId(officeId)
                .officeName(officeName)
                .officeAddress(officeAddress)
                .isOperational(isOperational)
                .canHostAtm(canHostAtm)
                .canIssueLoans(canIssueLoans)
                .canDispenseCash(canDispenseCash)
                .canAcceptCash(canAcceptCash)
                .officeFunds(bank.getTotalFunds())
                .rentalCost(rentalCost)
                .build();
        if (bank.getTotalFunds() < officeFunds) {
            throw new IllegalArgumentException("Insufficient funds in the bank/office");
        } else {
            bankOffice.setOfficeFunds(officeFunds);
        }
        if (atmCount > bank.getAtmCount()) {
            throw new IllegalArgumentException("Incorrect ATM count in bank/office");
        } else {
            bankOffice.setAtmCount(atmCount);
        }
        bank.setOfficeCount(bank.getOfficeCount() + 1);
        return bankOffice;
    }

    @Override
    public BankOffice getBankOfficeById(Long officeId) {
        return null;
    }

    @Override
    public void updateBankOfficeById(Long officeId) {}

    @Override
    public void deleteBankOfficeById(Long officeId) {}
}