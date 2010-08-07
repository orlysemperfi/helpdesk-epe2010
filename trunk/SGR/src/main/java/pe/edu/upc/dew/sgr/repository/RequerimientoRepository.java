package pe.edu.upc.dew.sgr.repository;

import java.util.List;
import pe.edu.upc.dew.sgr.domain.Requerimiento;

/**
 *
 * @author Administrador
 */
public interface RequerimientoRepository {
    public List<Requerimiento> obtenerRequerimientos();
    public List<Requerimiento> obtenerRequerimientosPorUsuario(int cod_usuario);
    public Requerimiento obtenerRequerimiento(int cod_req);
    public void grabarRequerimiento(Requerimiento obj);
    public void eliminarRequerimiento(int cod_req);
}
