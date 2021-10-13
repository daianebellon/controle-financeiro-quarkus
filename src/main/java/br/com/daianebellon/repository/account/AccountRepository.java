package br.com.daianebellon.repository.account;

import br.com.daianebellon.entity.account.Account;
import br.com.daianebellon.repository.MongoContext;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AccountRepository {

    @Inject
    MongoContext mongoContext;

    public void save(Account account) {
        getCollection().insertOne(account).await().indefinitely();
    }

    private ReactiveMongoCollection<Account> getCollection() {
        return mongoContext.getCollection("Account", Account.class);
    }

    public Optional<Account> findByDescription(String description) {
        return Optional.ofNullable(getCollection().find(new Document("description", description)).collect().first().await().indefinitely());
    }

    public List<Account> findAll() {
        return getCollection().find().collect().asList().await().indefinitely();
    }

    public void deleteById(ObjectId id) {
        getCollection().deleteOne(new Document("_id", id)).await().indefinitely();
    }
}
