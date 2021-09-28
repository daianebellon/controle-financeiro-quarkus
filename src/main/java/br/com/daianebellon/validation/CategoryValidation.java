package br.com.daianebellon.validation;

import br.com.daianebellon.dto.category.CategoryInputDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class CategoryValidation {

    public void validator(CategoryInputDto category) {
        Objects.requireNonNull(category.getDescription());
    }
}
