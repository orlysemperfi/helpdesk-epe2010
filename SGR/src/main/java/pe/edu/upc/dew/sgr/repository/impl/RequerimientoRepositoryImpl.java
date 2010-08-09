package pe.edu.upc.dew.sgr.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.dew.sgr.bd.Conexion;
import pe.edu.upc.dew.sgr.domain.Requerimiento;
import pe.edu.upc.dew.sgr.repository.RequerimientoRepository;

/**
 * @author Orly Forever
 */

public class RequerimientoRepositoryImpl 
        implements RequerimientoRepository {

    public List<Requerimiento> obtenerRequerimientosPorUsuario(int cod_usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rst = null;

        List<Requerimiento> requerimientos = new ArrayList<Requerimiento>();

        try {
             conn = Conexion.obtenerConexion();
             stmt = conn.createStatement();
             rst = stmt.executeQuery("select * from TB_REQUERIMIENTO where cod_usuario ='"+ cod_usuario +"'");
             if (rst.next()){
                 Requerimiento req = new Requerimiento();

                 req.setCod_requerimiento(rst.getInt("cod_requerimiento"));
                 req.setAno_ejercicio(rst.getString("ano_ejercicio"));
                 req.setCod_usuario(rst.getInt("cod_usuario"));
                 req.setTxt_asunto(rst.getString("txt_asunto"));
                 req.setTxt_descripcion(rst.getString("txt_descripcion"));
                 req.setFl_estado(rst.getInt("fl_estado"));
                 req.setFec_registro(rst.getDate("fec_registro"));
                 req.setFec_estado(rst.getDate("fec_estado"));

                 requerimientos.add(req);
             }
             else{
                 requerimientos = null;
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
        return requerimientos;
    }

}
