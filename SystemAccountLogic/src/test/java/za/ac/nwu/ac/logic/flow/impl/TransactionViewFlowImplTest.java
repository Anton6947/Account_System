package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionViewFlowImplTest {

    @Mock
    private AccountTransactionTranslator translator;

    @InjectMocks
    private TransactionViewFlowImplTest flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBalanceByMemberId() {
        AccountBalanceDto accountBalanceDto = translator.getBalanceByMemberId(1111L);
        verify(translator, atLeastOnce()).getBalanceByMemberId(anyLong());


    }
}
