package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.TransactionViewFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class TransactionViewFlowImpl implements TransactionViewFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public TransactionViewFlowImpl(AccountTransactionTranslator accountTransactionTranslator){
        this.accountTransactionTranslator = accountTransactionTranslator;
    }



    @Override
    public AccountBalanceDto getBalanceByMemberId(Long memberId){
        return accountTransactionTranslator.getBalanceByMemberId(memberId);
    }


//    @Override
//    public AccountTransaction getTransactionForMemberId(Long memberId){
//        return AccountTransactionTranslator.getBalanceByMemberId(memberId);
//    }



}
