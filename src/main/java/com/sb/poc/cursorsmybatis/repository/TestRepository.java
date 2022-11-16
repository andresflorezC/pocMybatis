package com.sb.poc.cursorsmybatis.repository;

import com.sb.poc.cursorsmybatis.dto.PrcParams;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface TestRepository {

    /**
     * Llamado al procedimiento getDBUSERCursor que tiene como parámetro de entrada un string y
     * como parámetros de salida dos cursores
     *
     * Usa los mappers userMap y creationTimesMap definidos en el
     * archivo mapper.xml ubicado en resources/sqlmapper
     */
    @Select("{" +
            "call getDBUSERCursor(" +
            "#{params.pUsername, jdbcType = VARCHAR, mode = IN }," +
            "#{params.users, jdbcType = CURSOR, javaType = ResultSet, resultMap=userMap, mode = OUT }," +
            "#{params.creationTimes, jdbcType = CURSOR, javaType = ResultSet, resultMap=creationTimesMap, mode = OUT }" +
            ")}")
    @Options(statementType = StatementType.CALLABLE)
    void prcConsulta(@Param("params") PrcParams params);
}
