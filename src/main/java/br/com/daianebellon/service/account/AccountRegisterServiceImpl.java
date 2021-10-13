package br.com.daianebellon.service.account;

import br.com.daianebellon.Converter.AccountConverter;
import br.com.daianebellon.dto.account.AccountInputDto;
import br.com.daianebellon.dto.account.AccountOutputDto;
import br.com.daianebellon.entity.account.Account;
import br.com.daianebellon.repository.account.AccountRepository;
import br.com.daianebellon.validation.AccountInputValidation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Optional;

@ApplicationScoped
public class AccountRegisterServiceImpl implements AccountRegisterService {

    @Inject
    AccountRepository accountRepository;

    @Inject
    AccountInputValidation accountInputValidation;

    @Override
    public AccountOutputDto register(AccountInputDto accountInputDto) {
        accountInputValidation.validate(accountInputDto);

        Optional<Account> byDescription = accountRepository.findByDescription(accountInputDto.getDescription());

        if (!byDescription.isEmpty()) {
            throw new IllegalArgumentException("Existing Account!!");
        }

        if (accountInputDto.getCurrentBalance() == null) {
            accountInputDto.setCurrentBalance(BigDecimal.ZERO);
        }

        var account = AccountConverter.executar(accountInputDto);
        accountRepository.save(account);
        return AccountConverter.executar(account);
    }
}
