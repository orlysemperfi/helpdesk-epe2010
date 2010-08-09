package pe.edu.upc.dew.sgr.repository;

import java.util.List;
import pe.edu.upc.dew.sgr.domain.Requerimiento;

/**
 * @author Orly Forever
 */

public interface RequerimientoRepository {
    public List<Requerimiento> obtenerRequerimientosPorUsuario(int cod_usuario);
}
