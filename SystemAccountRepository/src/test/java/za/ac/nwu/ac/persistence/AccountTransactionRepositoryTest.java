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
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class})
public class AccountTransactionRepositoryTest {

    @Autowired
    AccountTransactionRepository accountTransactionRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test(){

    }

//    @Test
//    public void getBalanceByMemberId(){
//        AccountTransaction memberId = accountTransactionRepository.getBalanceByMemberId("MEMBERID");
//        assertNotNull("MemberId",memberId.getMemberId());
//    }

}