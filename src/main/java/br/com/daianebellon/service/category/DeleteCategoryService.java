package br.com.daianebellon.service.category;

import org.bson.types.ObjectId;

public interface DeleteCategoryService {

    void deleteById(ObjectId id);
}
