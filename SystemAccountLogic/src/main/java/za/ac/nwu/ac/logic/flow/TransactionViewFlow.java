package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.util.List;

public interface TransactionViewFlow {

//     List<AccountTransactionDto>getAccountTransactions();

     AccountBalanceDto getBalanceByMemberId(Long memberId);

//     AccountTransaction getTransactionForMemberId(Long memberId);


}
