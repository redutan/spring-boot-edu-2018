package io.redutan.springboot.edu.account.ui;

import io.redutan.springboot.edu.account.Account;
import io.redutan.springboot.edu.account.application.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author myeongju.jung
 */
@RestController
public class AccountRestController {
    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/api/accounts")
    List<Account> accounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/api/accounts/{accountId}")
    Account account(@PathVariable Long accountId) {
        return accountService.getAccount(accountId);
    }
}
