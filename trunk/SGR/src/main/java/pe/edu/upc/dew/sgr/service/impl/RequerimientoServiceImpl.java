package pe.edu.upc.dew.sgr.service.impl;

import java.util.List;
import pe.edu.upc.dew.sgr.domain.Requerimiento;
import pe.edu.upc.dew.sgr.repository.RequerimientoRepository;
import pe.edu.upc.dew.sgr.service.RequerimientoService;

/**
 * @author Orly Forever
 */

public class RequerimientoServiceImpl
        implements RequerimientoService {

    private RequerimientoRepository requerimientoRepository;

    public List<Requerimiento> obtenerRequerimientosPorUsuario(int cod_usuario) {
        return requerimientoRepository.obtenerRequerimientosPorUsuario(cod_usuario);
    }

    public void setRequerimientoRepository (RequerimientoRepository requerimientoRepository){
        this.requerimientoRepository = requerimientoRepository;

    }
}
