package br.com.daianebellon.controller;

import br.com.daianebellon.dto.category.CategoryInputDto;
import br.com.daianebellon.dto.category.CategoryOutputDto;
import br.com.daianebellon.entity.category.Category;
import br.com.daianebellon.service.category.DeleteCategoryService;
import br.com.daianebellon.service.category.FindAllCategoriesService;
import br.com.daianebellon.service.category.RegisterCategoryService;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("category")
public class CategoryWS {

    @Inject
    RegisterCategoryService registerCategoryService;

    @Inject
    FindAllCategoriesService findAllCategoriesService;

    @Inject
    DeleteCategoryService deleteCategoryService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public CategoryOutputDto register(CategoryInputDto category) {
       return registerCategoryService.register(category);
    }

    @GET
    public List<Category> findAll() {
        return findAllCategoriesService.findAll();
    }

    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") ObjectId id) {
        deleteCategoryService.deleteById(id);
    }

}
