package br.com.daianebellon.dto.category;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryInputDto {

    @NotNull(message = "Description cannot be null!!")
    private String description;

}
