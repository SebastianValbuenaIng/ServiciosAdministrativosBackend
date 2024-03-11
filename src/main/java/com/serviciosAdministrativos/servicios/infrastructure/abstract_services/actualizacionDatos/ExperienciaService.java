package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.ExperienciaRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.ExperienciaEntity;

import java.util.List;
import java.util.Map;

public interface ExperienciaService {
    List<ExperienciaEntity> findAllExperienciasByEmpleado(String documento);
    ExperienciaEntity saveNewExperienceEmpleado(String documento, ExperienciaRequest experienciaRequest);
    ExperienciaEntity updateNewExperienceEmpleado(Integer id_experiencia, ExperienciaRequest experienciaRequest);
    Map<String, String> deleteNewExperienceEmpleado(Integer id_experiencia);
}
