package com.yorch.springboot.apirest.models.entity;

import java.io.Serializable;

public class Respuesta implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int codigo;
    private String mensaje;
    private Object data;
    public int getCodigo() {
        return codigo;
    }
    public Respuesta(){}

    public Respuesta(int codigo, String mensaje, Object data) {
        super();
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.data = data;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }



}
