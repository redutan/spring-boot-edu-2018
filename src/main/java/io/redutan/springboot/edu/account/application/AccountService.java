package io.redutan.springboot.edu.account.application;

import io.redutan.springboot.edu.account.Account;
import io.redutan.springboot.edu.account.AccountRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author myeongju.jung
 */
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccount(@NonNull Long accountId) {
        // TODO 2-2 : 계정 1건 조회 구현
        return null;
    }
}
