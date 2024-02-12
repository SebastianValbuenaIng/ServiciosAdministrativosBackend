package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import java.util.Map;

public interface ICclService {
    Map<String, String> VerificarVotoCcl(String email);
}
