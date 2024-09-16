package tech.reliab.course.chepurinpa.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BankOffice {

    private Long officeId;
    private String officeName;
    private String officeAddress;
    private Boolean isOperational;
    private Boolean canHostAtm;
    private Integer atmCount;
    private Boolean canIssueLoans;
    private Boolean canDispenseCash;
    private Boolean canAcceptCash;
    private Double officeFunds;
    private Double rentalCost;
    private Bank bank;
    private List<BankAtm> atms;

    @Override
    public String toString() {
        return "BankOffice {" +
                "\nofficeId=" + officeId +
                ", \nofficeName='" + officeName + '\'' +
                ", \nofficeAddress='" + officeAddress + '\'' +
                ", \nisOperational=" + isOperational +
                ", \ncanHostAtm=" + canHostAtm +
                ", \natmCount=" + atmCount +
                ", \ncanIssueLoans=" + canIssueLoans +
                ", \ncanDispenseCash=" + canDispenseCash +
                ", \ncanAcceptCash=" + canAcceptCash +
                ", \nofficeFunds=" + officeFunds +
                ", \nrentalCost=" + rentalCost +
                "\n}";
    }
}