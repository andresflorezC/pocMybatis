package com.sb.poc.cursorsmybatis.service;

import com.sb.poc.cursorsmybatis.dto.CreationTimes;
import com.sb.poc.cursorsmybatis.dto.PrcParams;
import com.sb.poc.cursorsmybatis.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;


    /**
     * Prueba de la llamado al procedimiento almacenado.
     * Imprime en consola los valores el contenido de los cursores de salida que fueron convertidos
     * a list java
     * El primero se imprime en rojo
     */
    //@PostConstruct
    public void postConstruct() {

        PrcParams prcParams = new PrcParams();
        prcParams.setPUsername("n");
        testRepository.prcConsulta(prcParams);

        System.out.println("----------------------------------------------");

        for (int i = 0; i < prcParams.getUsers().size(); i++) {
            System.err.println(prcParams.getUsers().get(i).getUsername());
        }

        for (int i = 0; i < prcParams.getCreationTimes().size(); i++) {
            List<CreationTimes> tu = prcParams.getCreationTimes();
            System.out.println(tu.get(i).getUserId() + "  " + tu.get(i).getDiffHours());
        }

    }

}
