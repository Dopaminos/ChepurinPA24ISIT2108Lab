package tech.reliab.course.chepurinpa.bank.service.implementation;

import tech.reliab.course.chepurinpa.bank.entity.Bank;
import tech.reliab.course.chepurinpa.bank.entity.BankAtm;
import tech.reliab.course.chepurinpa.bank.entity.BankOffice;
import tech.reliab.course.chepurinpa.bank.entity.Employee;
import tech.reliab.course.chepurinpa.bank.service.BankAtmService;

import java.util.HashMap;
import java.util.Map;

public class BankAtmServiceImplementation implements BankAtmService {

    private final Map<Long, BankAtm> bankAtmMap = new HashMap<>();

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
                .atmFunds(atmFunds)
                .maintenanceCost(maintenanceCost)
                .build();
        bankAtmMap.put(atmId, bankAtm);
        return bankAtm;
    }

    @Override
    public BankAtm getBankAtmById(Long atmId) {
        return bankAtmMap.get(atmId);
    }

    @Override
    public void updateBankAtmById(Long atmId, BankAtm bankAtm) {
        if (bankAtmMap.containsKey(atmId)) {
            bankAtmMap.put(atmId, bankAtm);
        } else {
            throw new IllegalArgumentException("Банкомат с ID " + atmId + " не существует.");
        }
    }

    @Override
    public void deleteBankAtmById(Long atmId) {
        if (bankAtmMap.containsKey(atmId)) {
            bankAtmMap.remove(atmId);
        } else {
            throw new IllegalArgumentException("Банкомат с ID " + atmId + " не существует.");
        }
    }
}