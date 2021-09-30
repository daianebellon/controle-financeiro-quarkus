package br.com.daianebellon.service.category;

import br.com.daianebellon.entity.category.Category;
import br.com.daianebellon.repository.category.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAllCategoriesServiceImplTest {

    @Test
    void checkFindAllCategories() {
        //mocks
        FindAllCategoriesServiceImpl findAllCategoriesService = new FindAllCategoriesServiceImpl();

        CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
        findAllCategoriesService.categoryRepository = categoryRepository;

        List<Category> categories = Arrays.asList(new Category("OPA"), new Category("Opa bao"), new Category("Tudo ok"));

        Mockito.when(findAllCategoriesService.findAll()).thenReturn(categories);

        //Actions
        List<Category> categoriesList = findAllCategoriesService.findAll();

        //Assertions
        Assertions.assertEquals(3, categoriesList.size());
        Assertions.assertEquals("OPA", categoriesList.get(0).getDescription());

    }
}