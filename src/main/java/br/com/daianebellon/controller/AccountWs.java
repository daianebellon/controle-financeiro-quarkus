package br.com.daianebellon.controller;

import br.com.daianebellon.dto.account.AccountInputDto;
import br.com.daianebellon.dto.account.AccountOutputDto;
import br.com.daianebellon.entity.account.Account;
import br.com.daianebellon.service.account.AccountRegisterService;
import br.com.daianebellon.service.account.DeleteByIdServiceServiceImpl;
import br.com.daianebellon.service.account.FindAllAccountService;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/accounts")
public class AccountWs {

    @Inject
    AccountRegisterService accountRegisterService;

    @Inject
    FindAllAccountService findAllAccountService;

    @Inject
    DeleteByIdServiceServiceImpl deleteById;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public AccountOutputDto register(AccountInputDto accountInputDto) {
       return accountRegisterService.register(accountInputDto);
    }

    @GET
    public List<Account> findAllAccountList() {
        return findAllAccountService.findAll();
    }

    @DELETE()
    @Path("/{id}")
    public void deleteById(@PathParam("id") ObjectId id) {
        deleteById.deleteById(id);
    }

}
