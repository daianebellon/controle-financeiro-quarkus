package br.com.daianebellon.service.category;

import br.com.daianebellon.entity.category.Category;
import br.com.daianebellon.repository.category.CategoryRepository;
import br.com.daianebellon.validation.IdValidation;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeleteCategoryImplTest {

    @Test
    void checkDeleteCategoryByIdNull() {
        DeleteCategoryServiceImpl deleteCategoryService = new DeleteCategoryServiceImpl();

        var idValidation = Mockito.mock(IdValidation.class);
        deleteCategoryService.idValidation = idValidation;

        Mockito.doThrow(new NullPointerException("Id cannot be null!")).when(idValidation).validatior(null);

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> deleteCategoryService.deleteById(null));

        Assertions.assertEquals("Id cannot be null!", exception.getMessage());
    }
}