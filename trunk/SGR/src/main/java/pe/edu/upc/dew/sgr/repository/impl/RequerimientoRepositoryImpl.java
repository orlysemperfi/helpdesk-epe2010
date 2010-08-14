package pe.edu.upc.dew.sgr.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
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

             while(rst.next()){
                 Requerimiento req = new Requerimiento();

                 req.setCod_requerimiento(rst.getInt("cod_requerimiento"));
                 req.setAno_ejercicio(rst.getString("ano_ejercicio"));
                 req.setCod_usuario(rst.getInt("cod_usuario"));
                 req.setTxt_asunto(rst.getString("txt_asunto"));
                 req.setTxt_descripcion(rst.getString("txt_descripcion"));
                 req.setFl_estado(rst.getInt("fl_estado"));
                 if(rst.getInt("fl_estado")==1){
                     req.setTxt_estado("Atendido");
                 }else{
                     req.setTxt_estado("Pendiente");
                 }
                 req.setFec_registro(rst.getDate("fec_registro"));
                 req.setFec_estado(rst.getDate("fec_estado"));

                 requerimientos.add(req);
             }

//             if (rst.next()){
//                 Requerimiento req = new Requerimiento();
//
//                 req.setCod_requerimiento(rst.getInt("cod_requerimiento"));
//                 req.setAno_ejercicio(rst.getString("ano_ejercicio"));
//                 req.setCod_usuario(rst.getInt("cod_usuario"));
//                 req.setTxt_asunto(rst.getString("txt_asunto"));
//                 req.setTxt_descripcion(rst.getString("txt_descripcion"));
//                 req.setFl_estado(rst.getInt("fl_estado"));
//                 req.setFec_registro(rst.getDate("fec_registro"));
//                 req.setFec_estado(rst.getDate("fec_estado"));
//
//                 requerimientos.add(req);
//             }
//             else{
//                 requerimientos = null;
//             }
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

    public int grabarRequerimiento(int codusuario, String asunto, String descripcion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        Date fechaActual = (new java.util.Date());

        int count = 0;

        try {
            conn = Conexion.obtenerConexion();

            stmt = conn.prepareStatement("INSERT INTO tb_requerimiento (cod_usuario, txt_asunto, txt_descripcion, fl_estado, fec_registro, fec_estado, ano_ejercicio) " +
                                         "VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, codusuario);
            stmt.setString(2, asunto);
            stmt.setString(3, descripcion);
            stmt.setInt(4, 2);
            //stmt.setString(5, DateFormat.getDateInstance(DateFormat.MEDIUM).format(fechaActual));
            stmt.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(fechaActual));
            //stmt.setString(6, DateFormat.getDateInstance("dd/MM/yyyy").format(fechaActual));
            stmt.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(fechaActual));
            stmt.setString(7, new SimpleDateFormat("yyyy").format(fechaActual));

            count = stmt.executeUpdate();
            //stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conexion.closeStatement(stmt);
            Conexion.closeConnection(conn);
        }

        return count;
    }

    public List<Requerimiento> obtenerRequerimientos() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rst = null;

        List<Requerimiento> requerimientos = new ArrayList<Requerimiento>();

        try {
             conn = Conexion.obtenerConexion();
             stmt = conn.createStatement();
             //rst = stmt.executeQuery("select * from TB_REQUERIMIENTO");

             rst = stmt.executeQuery("select req.*, CONCAT(u.txt_nombres, ' ', u.txt_apellido_paterno) AS txt_nombre " +
                                     "from TB_REQUERIMIENTO req " +
                                     "left join tb_usuario u on req.cod_usuario = u.cod_usuario");

             while(rst.next()){
                 Requerimiento req = new Requerimiento();

                 req.setCod_requerimiento(rst.getInt("cod_requerimiento"));
                 req.setAno_ejercicio(rst.getString("ano_ejercicio"));
                 req.setCod_usuario(rst.getInt("cod_usuario"));
                 req.setTxt_nombre(rst.getString("txt_nombre"));
                 req.setTxt_asunto(rst.getString("txt_asunto"));
                 req.setTxt_descripcion(rst.getString("txt_descripcion"));
                 req.setFl_estado(rst.getInt("fl_estado"));
                 if(rst.getInt("fl_estado")==1){
                     req.setTxt_estado("Atendido");
                 }else{
                     req.setTxt_estado("Pendiente");
                 }
                 req.setFec_registro(rst.getDate("fec_registro"));
                 req.setFec_estado(rst.getDate("fec_estado"));

                 requerimientos.add(req);
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
