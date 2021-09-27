package br.com.daianebellon.controller;

import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;
import br.com.daianebellon.service.category.RegisterCategoryService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("category")
public class CategoryWS {

    @Inject
    RegisterCategoryService registerCategoryService;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public CategoryOutputDto register(CategoryInputDto category) {
       return registerCategoryService.register(category);
    }

}
