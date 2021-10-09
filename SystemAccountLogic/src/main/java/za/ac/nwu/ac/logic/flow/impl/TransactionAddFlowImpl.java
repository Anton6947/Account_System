package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.TransactionAddFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class TransactionAddFlowImpl implements TransactionAddFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    public TransactionAddFlowImpl(AccountTransactionTranslator accountTransactionTranslator){
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDto addMiles(AccountTransactionDto accountTransactionAddMiles){
        if(null == accountTransactionAddMiles.getTransactionDate()){
            accountTransactionAddMiles.setTransactionDate(LocalDate.now());
        }
        try {
            if(accountTransactionAddMiles.getAmount()>0){
                accountTransactionAddMiles.setAmount(accountTransactionAddMiles.getAmount());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return  accountTransactionTranslator.create(accountTransactionAddMiles);
    }
}
