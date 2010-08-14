    package pe.edu.upc.dew.sgr.domain;

/**
 * @author Orly Forever
 */

public class Usuario {
        int cod_usuario;
        String txt_usuario;
        String txt_password;
        String txt_apellido_paterno;
        String txt_apellido_materno;
        String txt_nombres;
        String txt_doc_identidad;
        int cod_dependencia;
        int fl_tipo_usuario;

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getTxt_usuario() {
        return txt_usuario;
    }

    public void setTxt_usuario(String txt_usuario) {
        this.txt_usuario = txt_usuario;
    }

    public String getTxt_password() {
        return txt_password;
    }

    public void setTxt_password(String txt_password) {
        this.txt_password = txt_password;
    }

    public String getTxt_apellido_materno() {
        return txt_apellido_materno;
    }

    public void setTxt_apellido_materno(String txt_apellido_materno) {
        this.txt_apellido_materno = txt_apellido_materno;
    }

    public String getTxt_apellido_paterno() {
        return txt_apellido_paterno;
    }

    public void setTxt_apellido_paterno(String txt_apellido_paterno) {
        this.txt_apellido_paterno = txt_apellido_paterno;
    }

    public String getTxt_doc_identidad() {
        return txt_doc_identidad;
    }

    public void setTxt_doc_identidad(String txt_doc_identidad) {
        this.txt_doc_identidad = txt_doc_identidad;
    }

    public String getTxt_nombres() {
        return txt_nombres;
    }

    public void setTxt_nombres(String txt_nombres) {
        this.txt_nombres = txt_nombres;
    }

    public int getCod_dependencia() {
        return cod_dependencia;
    }

    public void setCod_dependencia(int cod_dependencia) {
        this.cod_dependencia = cod_dependencia;
    }

    public int getFl_tipo_usuario() {
        return fl_tipo_usuario;
    }

    public void setFl_tipo_usuario(int fl_tipo_usuario) {
        this.fl_tipo_usuario = fl_tipo_usuario;
    }
}
