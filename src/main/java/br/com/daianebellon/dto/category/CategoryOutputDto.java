package br.com.daianebellon.dto.category;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class CategoryOutputDto {

    private ObjectId id;
    private String description;

}
