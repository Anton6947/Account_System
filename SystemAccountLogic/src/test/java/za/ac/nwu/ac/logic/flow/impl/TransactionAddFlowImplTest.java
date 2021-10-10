package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionAddFlowImplTest {

    @Mock
    private AccountTransactionTranslator translator;

    @InjectMocks
    private TransactionAddFlowImpl flow;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addMiles() {
        when(translator.create(any(AccountTransactionDto.class))).then(returnsFirstArg());
        AccountTransactionDto result = flow.addMiles((new AccountTransactionDto(1111L, 2000L, LocalDate.now())));
        assertNotNull(result);
        verify(translator, atLeastOnce()).create(any(AccountTransactionDto.class));

    }
}