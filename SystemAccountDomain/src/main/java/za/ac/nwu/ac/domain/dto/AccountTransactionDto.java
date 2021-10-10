package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction",
            description = "A DTO that represents the AccountTransaction" )

public class AccountTransactionDto implements Serializable {


    private static final long serialVersionUID = -6323646193147923610L;


    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto( Long memberId, Long amount, LocalDate transactionDate) {

        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }


    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.memberId = accountTransaction.getMemberId();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(this.getMemberId(),this.getAmount(),this.getTransactionDate()); }

    @ApiModelProperty(position = 1,
            value =  "AccountTransaction memberId",
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
            value =  "AccountTransaction amount",
            name = "amount",
            notes = "The amount of the AccountTransaction",
            dataType = "java.lang.Long",
            example = "1000",
            required = true)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 3,
            value =  "AccountTransaction Transaction Date",
            name = "TransactionDate",
            notes = "This is the date on which the Transaction happened",
            dataType = "java.lang.String",
            example = "2020-01-01",
            allowEmptyValue = true)
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}