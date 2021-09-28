package br.com.daianebellon.service.category;

import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;
import br.com.daianebellon.repository.category.CategoryRepository;
import br.com.daianebellon.validation.CategoryValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegisterCategoryServiceImplTest {

    @Test
    void checkValidatorCategory() {
        RegisterCategoryServiceImpl registerCategoryService = new RegisterCategoryServiceImpl();

        CategoryValidation categoryValidation = Mockito.mock(CategoryValidation.class);
        CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
        registerCategoryService.categoryValidation = categoryValidation;
        registerCategoryService.categoryRepository = categoryRepository;

        CategoryInputDto categoryInputDto = new CategoryInputDto();
        Mockito.doThrow(NullPointerException.class).when(categoryValidation).validator(categoryInputDto);

        Assertions.assertThrows(NullPointerException.class, () -> registerCategoryService.register(categoryInputDto));
        Mockito.verify(categoryRepository, Mockito.never()).save(categoryInputDto);

    }

    @Test
    @DisplayName("should save Category when call Register")
    void checkRegisterCategory() {
        //mocks
        RegisterCategoryServiceImpl registerCategoryService = new RegisterCategoryServiceImpl();

        CategoryValidation categoryValidation = Mockito.mock(CategoryValidation.class);
        CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);
        registerCategoryService.categoryValidation = categoryValidation;
        registerCategoryService.categoryRepository = categoryRepository;

        CategoryInputDto categoryInputDto = new CategoryInputDto();
        categoryInputDto.setDescription("Hello");
        Mockito.doNothing().when(categoryValidation).validator(Mockito.any());

        CategoryOutputDto categoryOutputDto = new CategoryOutputDto();
        categoryOutputDto.setDescription(categoryInputDto.getDescription());

        Mockito.when(categoryRepository.save(categoryInputDto)).thenReturn(categoryOutputDto);

        //Action

        var registerCategory = registerCategoryService.register(categoryInputDto);

        //Assertivas
        Mockito.verify(categoryRepository).save(categoryInputDto);
        Assertions.assertEquals(categoryOutputDto.getDescription(), registerCategory.getDescription());

    }
}

