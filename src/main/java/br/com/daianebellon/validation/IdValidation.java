package br.com.daianebellon.validation;

import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class IdValidation {

    public void validatior(ObjectId id) {
        Objects.requireNonNull(id, "Id cannot be null!");
    }


}
