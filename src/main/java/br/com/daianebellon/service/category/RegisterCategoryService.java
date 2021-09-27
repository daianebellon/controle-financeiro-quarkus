package br.com.daianebellon.service.category;

import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;

public interface RegisterCategoryService {

    CategoryOutputDto register(CategoryInputDto category);
}
