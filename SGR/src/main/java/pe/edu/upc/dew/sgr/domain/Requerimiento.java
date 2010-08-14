package pe.edu.upc.dew.sgr.domain;

import java.util.Date;

/**
 * @author Orly Forever
 */

public class Requerimiento {
    private int cod_requerimiento;
    private String ano_ejercicio;
    private String txt_asunto;
    private Date fec_registro;
    private int cod_usuario;
    private String txt_nombre;
    private String txt_descripcion;
    private int  fl_estado;
    private String txt_estado;
    private Date fec_estado;

    public String getAno_ejercicio() {
        return ano_ejercicio;
    }

    public void setAno_ejercicio(String ano_ejercicio) {
        this.ano_ejercicio = ano_ejercicio;
    }

    public int getCod_requerimiento() {
        return cod_requerimiento;
    }

    public void setCod_requerimiento(int cod_requerimiento) {
        this.cod_requerimiento = cod_requerimiento;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(String txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    public Date getFec_registro() {
        return fec_registro;
    }

    public void setFec_registro(Date fec_registro) {
        this.fec_registro = fec_registro;
    }

    public Date getFec_estado() {
        return fec_estado;
    }

    public void setFec_estado(Date fec_estado) {
        this.fec_estado = fec_estado;
    }

    public int getFl_estado() {
        return fl_estado;
    }

    public void setFl_estado(int fl_estado) {
        this.fl_estado = fl_estado;
    }

    public String getTxt_estado() {
        return txt_estado;
    }

    public void setTxt_estado(String txt_estado) {
        this.txt_estado = txt_estado;
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
        return "cod_requerimiento " + cod_requerimiento + ", txt_asunto " + txt_asunto;
    }
}
