package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.AreasInteresEntity;

import java.util.List;
import java.util.Map;

public interface AreasInteresService {
    List<AreasInteresEntity> getAllAreasInteres(String cod_emp);
    Map<String, String> postAreasInteres(String cod_emp, List<String> areas_interes);
}
