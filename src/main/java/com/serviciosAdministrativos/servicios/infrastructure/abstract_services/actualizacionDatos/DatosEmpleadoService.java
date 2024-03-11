package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.InformacionEmpleadoRequest;
import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.response.DatosEmpleadoRedesSocialesResponse;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.DatosEmpleadoEntity;

public interface DatosEmpleadoService {
    DatosEmpleadoRedesSocialesResponse findDatosEmpleadoByCoEmp(String documento);
    DatosEmpleadoEntity newDatosEmpleadoToSave(String documento, InformacionEmpleadoRequest informacionEmpleadoRequest);
    void insertActualizaDatos();
}
