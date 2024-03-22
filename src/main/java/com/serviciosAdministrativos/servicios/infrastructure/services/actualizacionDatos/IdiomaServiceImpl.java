package com.serviciosAdministrativos.servicios.infrastructure.services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.AgregarIdiomaRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.IdiomasEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.IdiomasRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.IdiomaService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class IdiomaServiceImpl implements IdiomaService {
    private final IdiomasRepository idiomasRepository;

    public IdiomaServiceImpl(IdiomasRepository idiomasRepository) {
        this.idiomasRepository = idiomasRepository;
    }

    @Override
    public List<IdiomasEntity> findAllIdiomasByEmpleado(String documento) {
        return idiomasRepository.findAllByCodEmp(documento);
    }

    @Override
    public IdiomasEntity saveNewIdiomaEmpleado(String documento, AgregarIdiomaRequest agregarIdiomaRequest) {
        IdiomasEntity idiomaToSave = new IdiomasEntity(
                agregarIdiomaRequest.getCod_idioma(),
                documento,
                agregarIdiomaRequest.getCod_calif(),
                agregarIdiomaRequest.getCod_hab()
        );

        return idiomasRepository.save(idiomaToSave);
    }

    @Override
    public IdiomasEntity updateNewIdiomaEmpleado(Integer id_idioma, AgregarIdiomaRequest agregarIdiomaRequest) {
        Optional<IdiomasEntity> findIdiomaById = idiomasRepository.findById(id_idioma);

        if (findIdiomaById.isEmpty()) throw new NotFoundError("Idioma no encontrado.");

        findIdiomaById.get().setCodIdi(agregarIdiomaRequest.getCod_idioma());
        findIdiomaById.get().setCod_calif(agregarIdiomaRequest.getCod_calif());
        findIdiomaById.get().setCod_hab(agregarIdiomaRequest.getCod_hab());

        return idiomasRepository.save(findIdiomaById.get());
    }

    @Override
    public Map<String, String> deleteNewIdiomaEmpleado(Integer id_idioma) {
        Optional<IdiomasEntity> findIdiomaById = idiomasRepository.findById(id_idioma);

        if (findIdiomaById.isEmpty()) throw new NotFoundError("Idioma no encontrado.");

        idiomasRepository.delete(findIdiomaById.get());

        return Map.of("message", "Idioma eliminado correctamente.");
    }
}
