package br.com.daianebellon.Converter;

import br.com.daianebellon.dto.account.AccountInputDto;
import br.com.daianebellon.dto.account.AccountOutputDto;
import br.com.daianebellon.entity.account.Account;
import org.bson.types.ObjectId;

public class AccountConverter {

    public static Account executar(AccountInputDto accountInputDto) {
        Account account = new Account();
        account.setId(new ObjectId());
        account.setDescription(accountInputDto.getDescription());
        account.setCurrentBalance(accountInputDto.getCurrentBalance());
        return account;
    }

    public static AccountOutputDto executar(Account account) {
        AccountOutputDto accountOutputDto = new AccountOutputDto();
        accountOutputDto.setId(account.getId());
        accountOutputDto.setDescription(account.getDescription());
        accountOutputDto.setCurrentBalance(account.getCurrentBalance());
        return accountOutputDto;
    }
}
