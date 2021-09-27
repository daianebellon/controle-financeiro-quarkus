package br.com.daianebellon.service.category;

import br.com.daianebellon.entity.category.Category;
import br.com.daianebellon.repository.category.CategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FindAllCategoriesServiceImpl implements FindAllCategoriesService {

    @Inject
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
