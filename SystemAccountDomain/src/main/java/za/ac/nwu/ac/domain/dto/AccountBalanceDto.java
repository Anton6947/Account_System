package za.ac.nwu.ac.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "AccountBalance",
        description = "A DTO that represents the AccountBalance" )

public class AccountBalanceDto implements Serializable {

    private Long memberId;
    private Long balance;

    public AccountBalanceDto(){

    }

    public AccountBalanceDto(Long memberId, Long balance) {
        this.memberId = memberId;
        this.balance = balance;
    }



    @ApiModelProperty(position = 1,
            value =  "AccountBalance memberId",
            name = "memberId",
            notes = "Uniquely identifies the memberId",
            dataType = "java.lang.Long",
            example = "1111",
            required = true)
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(position = 2,
            value =  "AccountBalance balance",
            name = "Balance",
            notes = "The Balance of the Account",
            dataType = "java.lang.Long",
            example = "1000",
            required = true)
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountBalanceDto that = (AccountBalanceDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, balance);
    }

    @Override
    public String toString() {
        return "AccountBalanceDto{" +
                "memberId=" + memberId +
                ", balance=" + balance +
                '}';
    }
}
