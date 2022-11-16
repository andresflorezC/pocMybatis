package com.sb.poc.transactions.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ParamsProc2 {

    private BigDecimal pPersonId;
    private BigDecimal pSalary;
    private BigDecimal oProc;

}
