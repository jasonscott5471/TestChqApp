package cheque.core.repositories;

import cheque.core.models.entities.Account;

import java.util.List;

/**
 * Created by finwebmailer on 7/17/2016.
 */
public interface AccountRepo {
    public List<Account> findAllAccounts();
    public Account findAccount(Long id);
    public Account findAccountByName(String name);
    public Account createAccount(Account data);
}