package cheque.core.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import cheque.core.models.entities.Account;

/**
 * Created by finwebmailer on 7/17/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class AccountRepoTest {

    @Autowired
    private AccountRepo repo;
    private Account account;


    @Before
    @Transactional
    @Rollback(false)
    public void setup()
    {
        account = new Account();
        account.setName("Scott");
        account.setPassword("Scott");

        repo.createAccount(account);


    }

    @Test
    @Transactional
    public void testFind()
    {

        Assert.assertNotNull(repo.findAccount(account.getId()));

    }
}
