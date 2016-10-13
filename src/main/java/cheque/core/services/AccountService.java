package cheque.core.services;

import cheque.core.models.entities.Account;
import cheque.core.models.entities.Blog;
import cheque.core.services.util.AccountList;
import cheque.core.services.util.BlogList;

/**
 * Created by finwebmailer on 6/19/2016.
 */
public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
    public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
}