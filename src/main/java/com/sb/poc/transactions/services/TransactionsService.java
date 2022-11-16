package com.sb.poc.transactions.services;

import com.sb.poc.transactions.dto.ParamsProc1;
import com.sb.poc.transactions.dto.ParamsProc2;
import com.sb.poc.transactions.repository.PrcTransactionProc1;
import com.sb.poc.transactions.repository.PrcTransactionProc2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionsService {

    @Autowired
    PrcTransactionProc1 prcTransactionProc1;

    @Autowired
    PrcTransactionProc2 prcTransactionProc2;

    /**
     * Método para guardar empleado
     * Este método almacena un empleado en la base de datos.
     * En primer lugar almacena un registro en la tabla personas haciendo uso del procedimiento almacenado PRC_TRANSACTION_PROC1,
     * posteriormente almacena un registro en la tabla empleados haciendo uso del procedimiento PRC_TRANSACTION_PROC2.
     *
     * Este método actúa de manera transaccional, en este caso cuando falle el registro en la tabla empleados se realizará automáticamente
     * el rollback al registro que se realizó en la tabla personas.
     *
     * @throws Exception
     */
    @Transactional(rollbackFor = { Exception.class })
    public void saveEmployee() throws Exception {
        String name = "Nombre de la persona";

        ParamsProc1 paramsProc1 = ParamsProc1.builder().pNamePerson(name).build();

        System.out.println("Agregando a la tabla personas");
        prcTransactionProc1.callProcedure1(paramsProc1);


        System.out.println("Agregando a la tabla empleados");

        ParamsProc2 paramsProc2 = ParamsProc2.builder()
                .pPersonId(paramsProc1.getIdGenerado())
                .pSalary(BigDecimal.valueOf(-5)).build();
        prcTransactionProc2.callProcedure2(paramsProc2);

        if (paramsProc2.getOProc().equals(BigDecimal.valueOf(-1))) {
            throw new Exception("Empleado no registrado");
        }

    }

}
