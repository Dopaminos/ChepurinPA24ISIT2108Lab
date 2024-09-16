package tech.reliab.course.chepurinpa.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class Bank {

    private Long bankId;
    private String bankName;
    private Integer officeCount;
    private Integer atmCount;
    private Integer employeeCount;
    private Integer customerCount;
    private Integer bankRating;
    private Double totalFunds;
    private Double interestRate;
    @Builder.Default
    private List<BankAtm> atms = new ArrayList<>();
    @Builder.Default
    private List<BankOffice> offices = new ArrayList<>();
    @Builder.Default
    private List<Employee> employees = new ArrayList<>();
    @Builder.Default
    private List<User> users = new ArrayList<>();

    @Override
    public String toString() {
        return "Bank {" +
                "\nbankId=" + bankId +
                ", \nbankName='" + bankName + '\'' +
                ", \nofficeCount=" + officeCount +
                ", \natmCount=" + atmCount +
                ", \nemployeeCount=" + employeeCount +
                ", \ncustomerCount=" + customerCount +
                ", \nbankRating=" + bankRating +
                ", \ntotalFunds=" + totalFunds +
                ", \ninterestRate=" + interestRate +
                "\n}";
    }
}