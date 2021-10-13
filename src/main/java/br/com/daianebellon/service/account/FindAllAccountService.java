package br.com.daianebellon.service.account;

import br.com.daianebellon.dto.account.AccountOutputDto;
import br.com.daianebellon.entity.account.Account;

import java.util.List;

public interface FindAllAccountService {

    List<Account> findAll();

}
