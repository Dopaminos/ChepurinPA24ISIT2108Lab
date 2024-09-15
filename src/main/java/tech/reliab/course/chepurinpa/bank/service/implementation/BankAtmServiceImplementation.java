package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.BankAtm;
import tech.reliab.course.chepurinpa.bank.entity.BankOffice;
import tech.reliab.course.chepurinpa.bank.entity.Employee;
import tech.reliab.course.chepurinpa.bank.service.BankAtmService;

public class BankAtmServiceImplementation implements BankAtmService {

    @Override
    public BankAtm createBankAtm(Long atmId,
                                 String atmName,
                                 String atmStatus,
                                 Bank bank,
                                 BankOffice bankOffice,
                                 Employee servicingEmployee,
                                 Boolean canDispenseCash,
                                 Boolean canAcceptCash,
                                 Double atmFunds,
                                 Double maintenanceCost) {
        BankAtm bankAtm = BankAtm.builder()
                .atmId(atmId)
                .atmName(atmName)
                .atmAddress(bankOffice.getOfficeAddress())
                .atmStatus(atmStatus)
                .bank(bank)
                .bankOffice(bankOffice)
                .servicingEmployee(servicingEmployee)
                .canDispenseCash(canDispenseCash)
                .canAcceptCash(canAcceptCash)
                .maintenanceCost(maintenanceCost)
                .build();
        bank.setAtmCount(bank.getAtmCount() + 1);
        bankOffice.setAtmCount(bankOffice.getAtmCount() + 1);
        if (bank.getTotalFunds() < atmFunds) {
            throw new IllegalArgumentException("Insufficient funds in the bank for the ATM");
        } else {
            bankAtm.setAtmFunds(atmFunds);
        }
        return bankAtm;
    }

    @Override
    public BankAtm getBankAtmById(Long atmId) {
        return null;
    }

    @Override
    public void updateBankAtmById(Long atmId, BankAtm bankAtm) {}

    @Override
    public void deleteBankAtmById(Long atmId, BankAtm bankAtm) {}
}