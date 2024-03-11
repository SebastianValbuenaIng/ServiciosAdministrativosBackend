package com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request;

public class PerfilWebRequest {
    private String cargos_directivos;
    private String membresias;
    private String reconocimientos;
    private String cargo_titulo_web;
    private String parrafoUno;
    private String parrafoDos;

    public PerfilWebRequest(String cargos_directivos, String membresias, String reconocimientos, String cargo_titulo_web, String parrafoUno, String parrafoDos) {
        this.cargos_directivos = cargos_directivos;
        this.membresias = membresias;
        this.reconocimientos = reconocimientos;
        this.cargo_titulo_web = cargo_titulo_web;
        this.parrafoUno = parrafoUno;
        this.parrafoDos = parrafoDos;
    }

    public String getCargos_directivos() {
        return cargos_directivos;
    }

    public void setCargos_directivos(String cargos_directivos) {
        this.cargos_directivos = cargos_directivos;
    }

    public String getMembresias() {
        return membresias;
    }

    public void setMembresias(String membresias) {
        this.membresias = membresias;
    }

    public String getReconocimientos() {
        return reconocimientos;
    }

    public void setReconocimientos(String reconocimientos) {
        this.reconocimientos = reconocimientos;
    }

    public String getCargo_titulo_web() {
        return cargo_titulo_web;
    }

    public void setCargo_titulo_web(String cargo_titulo_web) {
        this.cargo_titulo_web = cargo_titulo_web;
    }

    public String getParrafoUno() {
        return parrafoUno;
    }

    public void setParrafoUno(String parrafoUno) {
        this.parrafoUno = parrafoUno;
    }

    public String getParrafoDos() {
        return parrafoDos;
    }

    public void setParrafoDos(String parrafoDos) {
        this.parrafoDos = parrafoDos;
    }
}
