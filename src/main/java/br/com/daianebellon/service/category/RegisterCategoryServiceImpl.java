package br.com.daianebellon.service.category;

import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;
import br.com.daianebellon.repository.category.CategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RegisterCategoryServiceImpl implements RegisterCategoryService {

    @Inject
    CategoryRepository categoryRepository;

    @Override
    public CategoryOutputDto register(CategoryInputDto category) {
        return categoryRepository.save(category);
    }
}
