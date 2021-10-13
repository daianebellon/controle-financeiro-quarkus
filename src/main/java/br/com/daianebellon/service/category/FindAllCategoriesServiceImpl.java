package br.com.daianebellon.service.category;

import br.com.daianebellon.entity.category.Category;
import br.com.daianebellon.repository.category.CategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Classe responável por buscar todas as categorias cadastradas.
 */
@ApplicationScoped
public class FindAllCategoriesServiceImpl implements FindAllCategoriesService {

    @Inject
    CategoryRepository categoryRepository;

    /**
     * Método reponsável por buscar todas as categorias.
     * @return retorna uma lista de categorias.
     */
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
