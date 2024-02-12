package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.CandidatosEntity;

import java.util.ArrayList;
import java.util.List;

public interface ICandidatosCclService {
    List<CandidatosEntity> buscarCandidatosCcl(Integer idcrp);
}
