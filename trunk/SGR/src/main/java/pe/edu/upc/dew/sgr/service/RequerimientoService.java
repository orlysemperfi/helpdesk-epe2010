package pe.edu.upc.dew.sgr.service;

import java.util.List;
import pe.edu.upc.dew.sgr.domain.Requerimiento;

/**
 *
 * @author Orly Forever
 */
public interface RequerimientoService {
        public List<Requerimiento> obtenerRequerimientosPorUsuario(int cod_usuario);
}
