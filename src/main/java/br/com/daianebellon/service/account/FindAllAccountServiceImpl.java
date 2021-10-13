package br.com.daianebellon.service.account;

import br.com.daianebellon.entity.account.Account;
import br.com.daianebellon.repository.account.AccountRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FindAllAccountServiceImpl implements  FindAllAccountService{

    @Inject
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
