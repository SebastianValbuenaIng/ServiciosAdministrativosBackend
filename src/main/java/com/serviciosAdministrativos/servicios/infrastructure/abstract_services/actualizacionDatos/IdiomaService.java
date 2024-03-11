package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.AgregarIdiomaRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.IdiomasEntity;

import java.util.List;
import java.util.Map;

public interface IdiomaService {
    List<IdiomasEntity> findAllIdiomasByEmpleado(String documento);
    IdiomasEntity saveNewIdiomaEmpleado(String documento, AgregarIdiomaRequest agregarIdiomaRequest);
    IdiomasEntity updateNewIdiomaEmpleado(Integer id_idioma, AgregarIdiomaRequest agregarIdiomaRequest);
    Map<String, String> deleteNewIdiomaEmpleado(Integer id_idioma);
}
