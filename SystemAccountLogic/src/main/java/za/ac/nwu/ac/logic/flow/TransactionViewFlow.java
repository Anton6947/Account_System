package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountBalanceDto;


public interface TransactionViewFlow {

    AccountBalanceDto getBalanceByMemberId(Long memberId);
}
