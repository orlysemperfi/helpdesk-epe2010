package pe.edu.upc.dew.sgr.domain;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class Requerimiento implements Serializable {
    private Integer cod_req;
    private String ano_ejercicio;
    private String txt_asunto;
    private String fec_registro;
    private String cod_usuario;
    private String txt_descripcion;
    private int fl_estado;
    private String fec_estado;

    public String getAno_ejercicio() {
        return ano_ejercicio;
    }

    public void setAno_ejercicio(String ano_ejercicio) {
        this.ano_ejercicio = ano_ejercicio;
    }

    public Integer getCod_req() {
        return cod_req;
    }

    public void setCod_req(Integer cod_req) {
        this.cod_req = cod_req;
    }

    public String getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(String cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getFec_registro() {
        return fec_registro;
    }

    public void setFec_registro(String fec_registro) {
        this.fec_registro = fec_registro;
    }

    public String getFec_estado() {
        return fec_estado;
    }

    public void setFec_estado(String fec_estado) {
        this.fec_estado = fec_estado;
    }

    public int getFl_estado() {
        return fl_estado;
    }

    public void setFl_estado(int fl_estado) {
        this.fl_estado = fl_estado;
    }

    public String getTxt_asunto() {
        return txt_asunto;
    }

    public void setTxt_asunto(String txt_asunto) {
        this.txt_asunto = txt_asunto;
    }

    public String getTxt_descripcion() {
        return txt_descripcion;
    }

    public void setTxt_descripcion(String txt_descripcion) {
        this.txt_descripcion = txt_descripcion;
    }

    @Override
    public String toString() {
        return "cod_req " + cod_req + ",txt_asunto " + txt_asunto;
    }
}
