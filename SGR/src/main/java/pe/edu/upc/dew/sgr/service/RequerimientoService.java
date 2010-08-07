package pe.edu.upc.dew.sgr.service;

import java.util.List;
import pe.edu.upc.dew.sgr.domain.Requerimiento;

/**
 *
 * @author Administrador
 */
public interface RequerimientoService {
    	public List<Requerimiento> obtenerRequerimientos();
        public List<Requerimiento> obtenerRequerimientosPorUsuario(String cod_usuario);
	public Requerimiento obtenerRequerimiento(String id);
	public void grabarRequerimiento(Requerimiento obj);
	public void eliminarRequerimiento(String id);
}
