package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {

//        AccountTypeDto accountTypeDto = new AccountTypeDto();
//        AccountTypeDto accountTypeDto2 = new AccountTypeDto("mnemonic2", "Name2", LocalDate.parse("2020-01-01"));
//        when(translator.create(any(AccountTypeDto.class))).thenReturn(accountTypeDto2);
//        AccountTypeDto result = flow.create(accountTypeDto);
//        assertNotNull(result);
//        verify(translator,times(2)).create(any(AccountTypeDto.class));
//        verify(translator,times(1)).create(eq(accountTypeDto2));
//
//        doThrow(new RuntimeException()).when(translator).someMethod();
//        try {
//            flow.create(new AccountTypeDto());
//            fail("Should throw an exception");
//            }catch (Exception e){
//        }
//        verify(translator,times(1)).someMethod();
//        verify(translator,never()).create(any(AccountTypeDto.class));
    }
}