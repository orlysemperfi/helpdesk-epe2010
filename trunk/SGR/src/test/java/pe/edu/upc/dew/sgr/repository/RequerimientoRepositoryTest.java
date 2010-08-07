package pe.edu.upc.dew.sgr.repository;

import pe.edu.upc.dew.sgr.domain.Requerimiento;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Administrador
 */
@ContextConfiguration(locations={"classpath:" +
    "pe/edu/upc/dew/sgr/system-test-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RequerimientoRepositoryTest {
    @Autowired
    RequerimientoRepository repository;

    @Test
    public void probarGrabarRequerimiento(){
        Requerimiento req = new Requerimiento();
        req.setAno_ejercicio("2010");
        req.setTxt_asunto("" +
                "Maquina lenta");
        req.setFec_registro("2010-06-26");
        req.setCod_usuario("2203");
        req.setTxt_descripcion("windows no carga");
        req.setFl_estado(1);
        req.setFec_estado("2010-06-26");

        repository.grabarRequerimiento(req);
    }
}
