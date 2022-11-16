package com.sb.poc.transactions.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ParamsProc1 {

    private String pNamePerson;
    private BigDecimal idGenerado;
}
