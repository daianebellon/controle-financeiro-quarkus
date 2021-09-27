package br.com.daianebellon.entity.category;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Category {

    private ObjectId id;

    @NotNull(message = "Description cannot be null!!")
    private String description;

}
