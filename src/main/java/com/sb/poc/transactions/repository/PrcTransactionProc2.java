package com.sb.poc.transactions.repository;

import com.sb.poc.transactions.dto.ParamsProc2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface PrcTransactionProc2 {

    /**
     * Llamado al procedimiento PRC_TRANSACTION_PROC2 que realiza una inserción en una tabla EMPLOYEES
     * @param params
     */
    @Select("{" +
            "call PCK_TEST_TRANSACTIONS.PRC_TRANSACTION_PROC2(" +
            "#{params.pPersonId, jdbcType = NUMERIC, mode = IN }," +
            "#{params.pSalary, jdbcType = NUMERIC, mode = IN }," +
            "#{params.oProc, jdbcType = NUMERIC, mode = OUT }" +
            ")}")
    @Options(statementType = StatementType.CALLABLE)
    void callProcedure2(@Param("params") ParamsProc2 params);

}
