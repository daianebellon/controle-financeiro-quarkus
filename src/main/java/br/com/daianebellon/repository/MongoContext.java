package br.com.daianebellon.repository;

import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import org.bson.Document;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MongoContext {

    @Inject
    ReactiveMongoClient mongoClient;

    @ConfigProperty(name = "quarkus.mongodb.database")
    String mongoDatabase;

    public ReactiveMongoCollection<Document> getCollection(String collection) {
        return mongoClient.getDatabase(mongoDatabase).getCollection(collection);
    }

    public <T> ReactiveMongoCollection<T> getCollection(String collection, Class<T> classe) {
        return mongoClient.getDatabase(mongoDatabase).getCollection(collection, classe);
    }
}


