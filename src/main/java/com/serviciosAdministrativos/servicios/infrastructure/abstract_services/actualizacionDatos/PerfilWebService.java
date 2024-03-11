package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.PerfilWebRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.PerfilWebEntity;

import java.util.Map;

public interface PerfilWebService {
    PerfilWebEntity getPerfilWeb(String documento);
    Map<String, String> postPerfilWeb(String documento, PerfilWebRequest perfilWebRequest);
}
