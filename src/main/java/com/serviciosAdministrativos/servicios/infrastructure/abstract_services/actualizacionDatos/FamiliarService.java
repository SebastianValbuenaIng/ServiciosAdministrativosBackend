package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.AgregarFamiliarRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.FamiliaEmpleadoEntity;

import java.util.List;
import java.util.Map;

public interface FamiliarService {
    List<FamiliaEmpleadoEntity> findAllFamiliarByEmpleado(String documento);
    FamiliaEmpleadoEntity newFamiliarByEmpleado(String documento, AgregarFamiliarRequest agregarFamiliarRequest);
    FamiliaEmpleadoEntity updateNewFamiliarByEmpleado(Integer id_familiar, AgregarFamiliarRequest agregarFamiliarRequest);
    Map<String, String> deleteNewFamiliarByEmpleado(Integer id_familiar);
}
