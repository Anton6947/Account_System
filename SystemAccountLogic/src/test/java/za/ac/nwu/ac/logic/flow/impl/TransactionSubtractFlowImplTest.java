package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionSubtractFlowImplTest {

    @Mock
    private AccountTransactionTranslator translator;

    @InjectMocks
    private TransactionSubtractFlowImpl flow;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void subtractMiles() {
        when(translator.create(any(AccountTransactionDto.class))).then(returnsFirstArg());
        AccountTransactionDto result = flow.subtractMiles((new AccountTransactionDto(1111L,2000L, LocalDate.now())));
        assertNotNull(result);
        verify(translator,atLeastOnce()).create(any(AccountTransactionDto.class));


    }
}