package br.com.daianebellon.service.account;

import br.com.daianebellon.repository.account.AccountRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeleteByIdServiceServiceImpl implements DeleteByIdService {

    @Inject
    AccountRepository accountRepository;

    @Override
    public void deleteById(ObjectId id) {
        accountRepository.deleteById(id);
    }
}
