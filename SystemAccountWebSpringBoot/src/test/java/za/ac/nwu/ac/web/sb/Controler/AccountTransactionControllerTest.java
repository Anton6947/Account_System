package za.ac.nwu.ac.web.sb.Controler;

import com.google.common.net.MediaType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.TransactionAddFlow;
import za.ac.nwu.ac.logic.flow.TransactionSubtractFlow;
import za.ac.nwu.ac.logic.flow.TransactionViewFlow;
import za.ac.nwu.ac.logic.flow.impl.TransactionSubtractFlowImpl;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTransactionControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String AccountTransactionController_URL = APP_URL + "/account-transaction";

    @Mock
    private TransactionAddFlow transactionAddFlow;

    @Mock
    private TransactionSubtractFlow transactionSubtractFlow;

    @Mock
    private TransactionViewFlow transactionViewFlow;

    @InjectMocks
    private AccountTransactionController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addMiles() throws Exception {
//        String expectedResponse = "{\"successful\":true,\"payload\":[" +
//                "{\"memberId\":\"1111\",\"balance\":\"4000\",\"transactionDate\":[2020,01,01]}]}";
//
//        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
//        accountTransactionDto.add(new AccountTransactionDto(1111L,1000L, LocalDate.parse("2020-01-01")));
//
//        when(transactionAddFlow.addMiles()).thenReturn(accountTransactionDto);
//
//        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",AccountTransactionController_URL,"add-miles")))
//                        .servletPath(APP_URL)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andReturn();
//        verify(transactionAddFlow,times(1)).addMiles();
//        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());


    }

    @Test
    public void subtractMiles() {
    }

    @Test
    public void getAccountTransaction() {
    }
}