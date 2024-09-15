package tech.reliab.course.chepurinpa.bank.service;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.BankAtm;
import tech.reliab.course.chepurinpa.bank.entity.BankOffice;
import tech.reliab.course.chepurinpa.bank.entity.Employee;

public interface BankAtmService {

    BankAtm createBankAtm(Long atmId,
                          String atmName,
                          String atmStatus,
                          Bank bank,
                          BankOffice bankOffice,
                          Employee servicingEmployee,
                          Boolean canDispenseCash,
                          Boolean canAcceptCash,
                          Double atmFunds,
                          Double maintenanceCost);

    BankAtm getBankAtmById(Long atmId);

    void updateBankAtmById(Long atmId, BankAtm bankAtm);

    void deleteBankAtmById(Long atmId, BankAtm bankAtm);
}