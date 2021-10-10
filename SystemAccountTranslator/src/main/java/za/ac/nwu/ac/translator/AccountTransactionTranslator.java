package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionTranslator {

    AccountTransactionDto create(AccountTransactionDto accountTransactionDto);

    AccountBalanceDto getBalanceByMemberId(Long memberId);

    List<AccountTransactionDto> getAccountTransactions(Long memberId);

    void someMethod();

}
