package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import com.serviciosAdministrativos.servicios.api.models.votaciones.request.VotoRequest;

import java.util.Map;

public interface IVotoActionsService {
    Map<String, String> save(VotoRequest votacionesRequest, String email);
}
