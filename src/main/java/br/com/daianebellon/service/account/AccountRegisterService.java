package br.com.daianebellon.service.account;

import br.com.daianebellon.dto.account.AccountInputDto;
import br.com.daianebellon.dto.account.AccountOutputDto;

public interface AccountRegisterService {

    AccountOutputDto register(AccountInputDto accountInputDto);

}
