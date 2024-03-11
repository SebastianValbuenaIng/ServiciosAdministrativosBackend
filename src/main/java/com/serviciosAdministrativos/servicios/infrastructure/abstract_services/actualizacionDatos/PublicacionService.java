package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.AgregarPublicacionRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.PublicacionesEntity;

import java.util.List;
import java.util.Map;

public interface PublicacionService {
    List<PublicacionesEntity> findAllPublicacionByEmpleado(String documento);
    PublicacionesEntity saveNewPublicacionEmpleado(String documento, AgregarPublicacionRequest agregarPublicacionRequest);
    PublicacionesEntity updateNewPublicacionEmpleado(Integer id_publicacion, AgregarPublicacionRequest agregarPublicacionRequest);
    Map<String, String> deleteNewPublicacionEmpleado(Integer id_publicacion);
}
