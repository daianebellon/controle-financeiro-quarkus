package br.com.daianebellon.entity.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Account {

    private ObjectId id;

    @NotNull(message = "Description cannot be null!!")
    private String description;

    @PositiveOrZero(message = "Only positive values!")
    private BigDecimal currentBalance;

}
