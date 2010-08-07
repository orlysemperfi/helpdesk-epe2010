package pe.edu.upc.dew.sgr.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.dew.sgr.domain.Requerimiento;
import pe.edu.upc.dew.sgr.repository.RequerimientoRepository;
import pe.edu.upc.dew.sgr.service.RequerimientoService;

/**
 *
 * @author Administrador
 */
@Service
public class RequerimientoServiceImpl implements RequerimientoService {
    @Autowired
    RequerimientoRepository repository;

    @Override
    public List<Requerimiento> obtenerRequerimientos() {
        return repository.obtenerRequerimientos();
    }

    @Override
    public List<Requerimiento> obtenerRequerimientosPorUsuario(String cod_usuario) {
        return repository.obtenerRequerimientosPorUsuario(Integer.valueOf(cod_usuario));
    }

    @Override
    public Requerimiento obtenerRequerimiento(String cod_req) {
        return repository.obtenerRequerimiento(Integer.valueOf(cod_req));
    }

    @Override
    public void grabarRequerimiento(Requerimiento obj) {
        repository.grabarRequerimiento(obj);
    }

    @Override
    public void eliminarRequerimiento(String cod_req) {
        repository.eliminarRequerimiento(Integer.valueOf(cod_req));
    }
}
