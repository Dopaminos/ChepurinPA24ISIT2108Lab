package tech.reliab.course.chepurinpa.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
public class CreditAccount {

    private Long creditAccountId;
    private User accountHolder;
    private String bankName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer creditDurationMonths;
    private Double creditAmount;
    private Double monthlyPayment;
    private Double interestRate;
    private Employee issuingEmployee;
    private PaymentAccount linkedPaymentAccount;

    @Override
    public String toString() {
        return "CreditAccount {" +
                "\ncreditAccountId=" + creditAccountId +
                ", \naccountHolderId=" + accountHolder.getUserId() +
                ", \nbankName='" + bankName + '\'' +
                ", \nstartDate=" + startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", \nendDate=" + endDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", \ncreditDurationMonths=" + creditDurationMonths +
                ", \ncreditAmount=" + creditAmount +
                ", \nmonthlyPayment=" + monthlyPayment +
                ", \ninterestRate=" + interestRate +
                ", \nissuingEmployeeId=" + issuingEmployee.getEmployeeId() +
                ", \nlinkedPaymentAccountId=" + linkedPaymentAccount.getPaymentAccountId() +
                "\n}";
    }
}