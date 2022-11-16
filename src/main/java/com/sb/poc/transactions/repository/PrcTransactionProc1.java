package com.sb.poc.transactions.repository;

import com.sb.poc.transactions.dto.ParamsProc1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface PrcTransactionProc1 {
    /**
     * Llamado al procedimiento PRC_TRANSACTION_PROC1 que realiza una inserción en una tabla PERSONS
     * @param params
     */
    @Select("{" +
            "call PCK_TEST_TRANSACTIONS.PRC_TRANSACTION_PROC1(" +
            "#{params.pNamePerson, jdbcType = VARCHAR, mode = IN }," +
            "#{params.idGenerado, jdbcType = NUMERIC, mode = OUT }" +
            ")}")
    @Options(statementType = StatementType.CALLABLE)
    void callProcedure1(@Param("params") ParamsProc1 params);

}
