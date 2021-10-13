package br.com.daianebellon.dto.account;

import lombok.Data;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@Data
public class AccountOutputDto {

    private ObjectId id;
    private String description;
    private BigDecimal currentBalance;

}
