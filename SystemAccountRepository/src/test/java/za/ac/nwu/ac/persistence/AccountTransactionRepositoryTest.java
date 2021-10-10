package za.ac.nwu.ac.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.ac.config.RepositoryTestConfig;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class AccountTransactionRepositoryTest {

    @Autowired
    AccountTransactionRepository accountTransactionRepository;

    @Before
    public void setUp() throws Exception {
        accountTransactionRepository.save( new AccountTransaction(0L,1111L,2000L, LocalDate.now()));
        accountTransactionRepository.save( new AccountTransaction(0L,1111L,2001L, LocalDate.now()));
        accountTransactionRepository.save( new AccountTransaction(0L,1111L,-200L, LocalDate.now()));
        accountTransactionRepository.save(  new AccountTransaction(0L,1111L,50L, LocalDate.now()));
    }

    @After
    public void tearDown() throws Exception {
        accountTransactionRepository = null;
    }

    @Test
    public void getBalanceByMemberId(){

        AccountBalanceDto result = accountTransactionRepository.getBalanceByMemberId(1111L);

        assertNotNull(result);
        assertTrue(result.getBalance()== 3851L);



    }





}