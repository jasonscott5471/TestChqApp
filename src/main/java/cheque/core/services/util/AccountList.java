package cheque.core.services.util;

import cheque.core.models.entities.Account;

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