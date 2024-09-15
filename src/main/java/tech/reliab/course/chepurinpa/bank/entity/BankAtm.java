package tech.reliab.course.chepurinpa.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankAtm {

    private Long atmId;
    private String atmName;
    private String atmAddress;
    private String atmStatus;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee servicingEmployee;
    private Boolean canDispenseCash;
    private Boolean canAcceptCash;
    private Double atmFunds;
    private Double maintenanceCost;

    @Override
    public String toString() {
        return "BankAtm {" +
                "\natmId=" + atmId +
                ", \natmName='" + atmName + '\'' +
                ", \natmAddress='" + atmAddress + '\'' +
                ", \natmStatus='" + atmStatus + '\'' +
                ", \nbankId=" + bank.getBankId() +
                ", \nbankOfficeId=" + bankOffice.getOfficeId() +
                ", \nservicingEmployeeId=" + servicingEmployee.getEmployeeId() +
                ", \ncanDispenseCash=" + canDispenseCash +
                ", \ncanAcceptCash=" + canAcceptCash +
                ", \natmFunds=" + atmFunds +
                ", \nmaintenanceCost=" + maintenanceCost +
                "\n}";
    }
}