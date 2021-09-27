package br.com.daianebellon.repository.category;

import br.com.daianebellon.Converter.Converter;
import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;
import br.com.daianebellon.entity.category.Category;
import br.com.daianebellon.repository.MongoContext;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CategoryRepository{

    @Inject
    MongoContext mongoContext;

    public CategoryOutputDto save(CategoryInputDto categoryInput) {
       if (categoryInput.getDescription() == null) {
            throw new IllegalArgumentException("Descrição nula");
       } else {
            var category = Converter.executar(categoryInput);
            getCollection().insertOne(category).await().indefinitely();
            return Converter.executar(category);
       }
    }

    private ReactiveMongoCollection<Category> getCollection() {
         return mongoContext.getCollection("RegisterCategory", Category.class);
    }

}
