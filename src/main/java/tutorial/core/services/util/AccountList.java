package tutorial.core.services.util;

import tutorial.core.models.entities.Account;
import tutorial.core.models.entities.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by finwebmailer on 7/19/2016.
 */
public class AccountList {

    private List<Account> accounts = new ArrayList<Account>();

    public AccountList(List<Account> list) {
        this.accounts = list;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}