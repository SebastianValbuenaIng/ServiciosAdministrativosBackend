package com.serviciosAdministrativos.servicios.infrastructure.services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.PerfilWebRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.PerfilWebEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.PerfilWebRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.PerfilWebService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PerfilWebServiceImpl implements PerfilWebService {
    private final PerfilWebRepository perfilWebRepository;

    public PerfilWebServiceImpl(PerfilWebRepository perfilWebRepository) {
        this.perfilWebRepository = perfilWebRepository;
    }

    @Override
    public PerfilWebEntity getPerfilWeb(String documento) {
        Optional<PerfilWebEntity> findPerfilWebByEmpleado = perfilWebRepository.findByCodEmp(documento);

        if (findPerfilWebByEmpleado.isEmpty()) throw new NotFoundError("El perfil no existe para ese empleado");

        return findPerfilWebByEmpleado.get();
    }

    @Override
    public Map<String, String> postPerfilWeb(String documento, PerfilWebRequest perfilWebRequest) {
        Optional<PerfilWebEntity> findPerfilWebByEmpleado = perfilWebRepository.findByCodEmp(documento);

        if (findPerfilWebByEmpleado.isEmpty()) {
            PerfilWebEntity perfilWebEntity = new PerfilWebEntity(
                    documento,
                    perfilWebRequest.getCargos_directivos(),
                    perfilWebRequest.getMembresias(),
                    perfilWebRequest.getReconocimientos(),
                    perfilWebRequest.getCargo_titulo_web(),
                    perfilWebRequest.getParrafoUno(),
                    perfilWebRequest.getParrafoDos()
            );

            perfilWebRepository.save(perfilWebEntity);

            return Map.of("message", "");
        }

        findPerfilWebByEmpleado.get().setCargo_tit_web(perfilWebRequest.getCargo_titulo_web());
        findPerfilWebByEmpleado.get().setReconocimientos(perfilWebRequest.getReconocimientos());
        findPerfilWebByEmpleado.get().setMembresias(perfilWebRequest.getMembresias());
        findPerfilWebByEmpleado.get().setCargo_direc(perfilWebRequest.getCargos_directivos());
        findPerfilWebByEmpleado.get().setParrafo1(perfilWebRequest.getParrafoUno());
        findPerfilWebByEmpleado.get().setParrafo2(perfilWebRequest.getParrafoDos());

        perfilWebRepository.save(findPerfilWebByEmpleado.get());

        return Map.of("message", "");
    }
}
