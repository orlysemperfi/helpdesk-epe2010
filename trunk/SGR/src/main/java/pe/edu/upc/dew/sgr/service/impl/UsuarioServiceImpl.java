package pe.edu.upc.dew.sgr.service.impl;

import pe.edu.upc.dew.sgr.domain.Usuario;
import pe.edu.upc.dew.sgr.repository.UsuarioRepository;
import pe.edu.upc.dew.sgr.service.UsuarioService;

/**
 * @author Orly Forever
 */

public class UsuarioServiceImpl 
        implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioPorUsername(String val) {
        return usuarioRepository.getUsuarioPorUsername(val);
    }

    public void setUsuarioRepository (UsuarioRepository usuarioRepository ){
        this.usuarioRepository = usuarioRepository;

    }

    public Usuario getUsuarioPorCodigo(int val) {
        return usuarioRepository.getUsuarioPorCodigo(val);
    }

}
