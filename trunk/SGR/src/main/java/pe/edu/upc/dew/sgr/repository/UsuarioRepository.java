package pe.edu.upc.dew.sgr.repository;

import pe.edu.upc.dew.sgr.domain.Usuario;

/**
 * * @author Orly Forever
 */

public interface UsuarioRepository {
    public Usuario getUsuarioPorUsername(String username);
}
