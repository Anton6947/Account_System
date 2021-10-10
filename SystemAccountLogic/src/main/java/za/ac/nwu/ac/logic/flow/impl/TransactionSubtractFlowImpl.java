package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.TransactionSubtractFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;


@Transactional
@Component
public class TransactionSubtractFlowImpl implements TransactionSubtractFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionSubtractFlow.class);

    private final AccountTransactionTranslator accountTransactionTranslator;

    public TransactionSubtractFlowImpl(AccountTransactionTranslator accountTransactionTranslator){
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDto subtractMiles(AccountTransactionDto accountTransactionSubtractMiles) {

        LOGGER.info("The input object was {}",accountTransactionSubtractMiles);

        if (null == accountTransactionSubtractMiles.getTransactionDate()) {
            accountTransactionSubtractMiles.setTransactionDate(LocalDate.now());
        }
        try {
            if (accountTransactionSubtractMiles.getAmount() > 0) {
                accountTransactionSubtractMiles.setAmount(-accountTransactionSubtractMiles.getAmount());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        return accountTransactionTranslator.create(accountTransactionSubtractMiles);

    }
    public boolean methodToTest(){
        return true;
    }
}
