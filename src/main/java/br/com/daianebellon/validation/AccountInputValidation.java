package br.com.daianebellon.validation;

import br.com.daianebellon.dto.account.AccountInputDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class AccountInputValidation {

    public void validate(AccountInputDto accountInputDto) {
        Objects.requireNonNull(accountInputDto,"cannot be null ");
    }

}
