package pe.edu.upc.dew.sgr.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.edu.upc.dew.sgr.bd.Conexion;
import pe.edu.upc.dew.sgr.domain.Usuario;
import pe.edu.upc.dew.sgr.repository.UsuarioRepository;

/**
 * * @author Orly Forever
 */

public class UsuarioRepositoryImpl 
        implements UsuarioRepository {

    public Usuario getUsuarioPorUsername(String username) {
        Usuario usuario = new Usuario();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rst = null;
        try {
             conn = Conexion.obtenerConexion();
             stmt = conn.createStatement();
             rst = stmt.executeQuery("select * from TB_USUARIO where txt_usuario ='"+username+"'");
             if (rst.next()){
                 usuario.setCod_usuario(Integer.parseInt(rst.getString("cod_usuario")));
                 usuario.setTxt_nombres(rst.getString("txt_nombres"));
                 usuario.setTxt_password(rst.getString("txt_password"));
                 usuario.setTxt_apellido_paterno(rst.getString("txt_apellido_paterno"));
                 usuario.setTxt_apellido_materno(rst.getString("txt_apellido_materno"));
                 usuario.setFl_tipo_usuario(Integer.parseInt(rst.getString("fl_tipo_usuario")));
             }
             else{
                 usuario = null;
             }
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally {
            Conexion.closeResultSet(rst);
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
        return usuario;
        }

    public Usuario getUsuarioPorCodigo(int codigo) {
        Usuario usuario = new Usuario();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rst = null;
        try {
             conn = Conexion.obtenerConexion();
             stmt = conn.createStatement();
             rst = stmt.executeQuery("select * from TB_USUARIO where cod_usuario ="+codigo+"");
             if (rst.next()){
                 usuario.setCod_usuario(Integer.parseInt(rst.getString("cod_usuario")));
                 usuario.setTxt_nombres(rst.getString("txt_nombres"));
                 usuario.setTxt_password(rst.getString("txt_password"));
                 usuario.setTxt_apellido_paterno(rst.getString("txt_apellido_paterno"));
                 usuario.setTxt_apellido_materno(rst.getString("txt_apellido_materno"));
                 usuario.setFl_tipo_usuario(Integer.parseInt(rst.getString("fl_tipo_usuario")));
             }
             else{
                 usuario = null;
             }
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally {
            Conexion.closeResultSet(rst);
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }
        return usuario;
        }
}
