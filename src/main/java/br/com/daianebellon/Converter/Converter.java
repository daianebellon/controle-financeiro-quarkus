package br.com.daianebellon.Converter;

import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;
import br.com.daianebellon.entity.category.Category;
import org.bson.types.ObjectId;

public class Converter {

    public static CategoryOutputDto executar(Category category) {
        CategoryOutputDto categoryOutputDto = new CategoryOutputDto();
        categoryOutputDto.setId(category.getId());
        categoryOutputDto.setDescription(category.getDescription());
        return categoryOutputDto;
    }

    public static Category executar(CategoryInputDto categoryInputDto) {
        Category category = new Category();
        category.setId(new ObjectId());
        category.setDescription(categoryInputDto.getDescription());
        return category;
    }

 }
