package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;
import java.util.List;
import java.util.Map;

public interface IVotacionActivaService {
     List<Map<String, String>> buscarVotaciones(Integer estado, String email);
}
