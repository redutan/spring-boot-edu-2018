package io.redutan.springboot.edu.config;

import io.redutan.springboot.edu.account.Account;
import io.redutan.springboot.edu.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author myeongju.jung
 */
@Configuration
public class SampleConfig {
    @Autowired
    AccountRepository accountRepository;

    @Bean
    CommandLineRunner samplesCreators() {
        return (String... args) -> accountRepository.save(Arrays.asList(
                Account.forCreate("mandoo", "만두"),
                Account.forCreate("jordan", "조던"),
                Account.forCreate("dongmyo", "동묘"),
                Account.forCreate("doogi", "두기"),
                Account.forCreate("comtin", "콤틴"),
                Account.forCreate("franky", "프랑키"),
                Account.forCreate("manti", "만티"),
                Account.forCreate("bureung", "부릉")));
    }
}
