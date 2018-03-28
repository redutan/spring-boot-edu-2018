package io.redutan.springboot.edu.account.ui;

import io.redutan.springboot.edu.account.Account;
import io.redutan.springboot.edu.account.application.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * WebMvcTest와 MockBean을 이용한 웹 부분은 통합으로 로딩하고 나머지는 단위적으로 테스트
 *
 * @author myeongju.jung
 */
// TODO 1-1 : @RunWith(S_____Runner.class)
@SuppressWarnings("WeakerAccess")
@WebMvcTest
public class AccountRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    // TODO 1-2 : @M___B___ : hint Mocking
    AccountService accountService;

    @Test
    public void getAccount() throws Exception {
        // given
        Long accountId = random(Long.class);
        Account account = random(Account.class);
        given(accountService.getAccount(accountId)).willReturn(account);
        // when
        mockMvc.perform(get("/api/accounts/{0}", accountId)
                                .accept(MediaType.APPLICATION_JSON))
               // then
               .andExpect(status().isOk()) // FIXME 1-3 : 성공 응답
               .andExpect(jsonPath("$.accountId").value(account.getAccountId()))
               //.andExpect(jsonPath("$.____").value(account.getName()))  // FIXME 1-4 : 성공 응답
               ;
        // then2
        then(accountService).should(times(2)).getAccount(accountId);    // ?!
    }
}