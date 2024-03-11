package com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request;

public class AgregarIdiomaRequest {
    private String cod_idioma;
    private String cod_calif;
    private String cod_hab;

    public AgregarIdiomaRequest(String cod_idioma, String cod_calif, String cod_hab) {
        this.cod_idioma = cod_idioma;
        this.cod_calif = cod_calif;
        this.cod_hab = cod_hab;
    }

    public String getCod_idioma() {
        return cod_idioma;
    }

    public void setCod_idioma(String cod_idioma) {
        this.cod_idioma = cod_idioma;
    }

    public String getCod_calif() {
        return cod_calif;
    }

    public void setCod_calif(String cod_calif) {
        this.cod_calif = cod_calif;
    }

    public String getCod_hab() {
        return cod_hab;
    }

    public void setCod_hab(String cod_hab) {
        this.cod_hab = cod_hab;
    }
}
