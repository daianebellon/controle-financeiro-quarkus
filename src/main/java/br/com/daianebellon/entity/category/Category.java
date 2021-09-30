package br.com.daianebellon.entity.category;

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

    public Category(String description) {
        this.description = description;
    }
}
