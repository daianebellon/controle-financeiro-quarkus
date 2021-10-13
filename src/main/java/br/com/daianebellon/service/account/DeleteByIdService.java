package br.com.daianebellon.service.account;

import org.bson.types.ObjectId;

public interface DeleteByIdService {

    void deleteById(ObjectId id);
}
