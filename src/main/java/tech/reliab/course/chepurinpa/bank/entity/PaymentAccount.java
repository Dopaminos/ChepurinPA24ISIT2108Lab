package tech.reliab.course.chepurinpa.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaymentAccount {

    private Long paymentAccountId;
    private User accountHolder;
    private String bankName;
    private Double balance;
    private Bank bank;
    @Override
    public String toString() {
        return "PaymentAccount {" +
                "\npaymentAccountId=" + paymentAccountId +
                ", \naccountHolderId=" + accountHolder.getUserId() +
                ", \nbankName='" + bankName + '\'' +
                ", \nbalance=" + balance +
                "\n}";
    }
}