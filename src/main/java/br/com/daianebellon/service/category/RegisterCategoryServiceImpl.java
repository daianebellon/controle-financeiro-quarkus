package br.com.daianebellon.service.category;

import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;
import br.com.daianebellon.repository.category.CategoryRepository;
import br.com.daianebellon.validation.CategoryValidation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RegisterCategoryServiceImpl implements RegisterCategoryService {

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    CategoryValidation categoryValidation;

    @Override
    public CategoryOutputDto register(CategoryInputDto category) {
        categoryValidation.validator(category);
        return categoryRepository.save(category);
    }
}
