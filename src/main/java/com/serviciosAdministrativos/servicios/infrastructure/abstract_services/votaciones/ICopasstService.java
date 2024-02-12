package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import java.util.Map;

public interface ICopasstService {
    Map<String, String> verificarEstadoVoto(String email);
}
