package tech.reliab.course.chepurinpa.bank.service;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.BankOffice;

public interface BankOfficeService {

    BankOffice createBankOffice(Long officeId,
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
                                Bank bank);

    BankOffice getBankOfficeById(Long officeId);

    void updateBankOfficeById(Long officeId, BankOffice bankOffice);

    void deleteBankOfficeById(Long officeId);
}