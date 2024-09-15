package tech.reliab.course.chepurinpa.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class User {

    private Long userId;
    private String fullName;
    private LocalDate birthDate;
    private String workplace;
    private Double monthlyIncome;
    private List<Bank> associatedBanks;
    @Builder.Default
    private List<CreditAccount> creditAccounts = new ArrayList<>();
    @Builder.Default
    private List<PaymentAccount> paymentAccounts = new ArrayList<>();
    private Integer creditRating;

    @Override
    public String toString() {
        return "User {" +
                "\nuserId=" + userId +
                ", \nfullName='" + fullName + '\'' +
                ", \nbirthDate=" + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", \nworkplace='" + workplace + '\'' +
                ", \nmonthlyIncome=" + monthlyIncome +
                ", \nassociatedBanksIds=" + associatedBanks.stream().map(Bank::getBankId).toList() +
                ", \ncreditAccountsIds=" + creditAccounts.stream().map(CreditAccount::getCreditAccountId).toList() +
                ", \npaymentAccountsIds=" + paymentAccounts.stream().map(PaymentAccount::getPaymentAccountId).toList() +
                ", \ncreditRating=" + creditRating +
                "\n}";
    }
}