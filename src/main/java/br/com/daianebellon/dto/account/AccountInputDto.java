package br.com.daianebellon.dto.account;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
public class AccountInputDto {

    @NotNull(message = "Description cannot be null!!")
    private String description;

    @PositiveOrZero(message = "Only positive values!")
    private BigDecimal currentBalance;
}
