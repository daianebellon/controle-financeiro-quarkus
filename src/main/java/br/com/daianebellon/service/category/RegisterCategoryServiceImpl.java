package br.com.daianebellon.service.category;

import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;
import br.com.daianebellon.repository.category.CategoryRepository;
import br.com.daianebellon.validation.CategoryValidation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Classe responsável pelo cadastro de categorias.
 */
@ApplicationScoped
public class RegisterCategoryServiceImpl implements RegisterCategoryService {

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    CategoryValidation categoryValidation;

    /**
     * Método responsável por cadastrar a Categoria.
     * @param category parametro recebido do usuario com a descrição da categoria.
     * @return Categoria com id e descrição cadastradas.
     */
    @Override
    public CategoryOutputDto register(CategoryInputDto category) {
        categoryValidation.validator(category);
        return categoryRepository.save(category);
    }
}
