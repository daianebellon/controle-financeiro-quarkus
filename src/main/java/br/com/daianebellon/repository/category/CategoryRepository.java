package br.com.daianebellon.repository.category;

import br.com.daianebellon.Converter.Converter;
import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;
import br.com.daianebellon.entity.category.Category;
import br.com.daianebellon.repository.MongoContext;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CategoryRepository {

    @Inject
    MongoContext mongoContext;

    public CategoryOutputDto save(CategoryInputDto categoryInput) {
        var category = Converter.executar(categoryInput);
        getCollection().insertOne(category).await().indefinitely();
        return Converter.executar(category);
    }

    public List<Category> findAll() {
       return getCollection().find().collect().asList().await().indefinitely();
    }

    public void deleteById(ObjectId id) {
        getCollection().deleteOne(new Document("_id", id)).await().indefinitely();
    }

    private ReactiveMongoCollection<Category> getCollection() {
        return mongoContext.getCollection("Category", Category.class);
    }


}
