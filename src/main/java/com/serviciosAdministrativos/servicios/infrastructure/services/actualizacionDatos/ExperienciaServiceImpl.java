package com.serviciosAdministrativos.servicios.infrastructure.services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.ExperienciaRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.DatosEmpleadoEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.ExperienciaEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.DatosEmpleadoRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.ExperienciaRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.ExperienciaService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExperienciaServiceImpl implements ExperienciaService {
    private final ExperienciaRepository experienciaRepository;
    private final DatosEmpleadoRepository datosEmpleadoRepository;

    public ExperienciaServiceImpl(ExperienciaRepository experienciaRepository, DatosEmpleadoRepository datosEmpleadoRepository) {
        this.experienciaRepository = experienciaRepository;
        this.datosEmpleadoRepository = datosEmpleadoRepository;
    }

    @Override
    public List<ExperienciaEntity> findAllExperienciasByEmpleado(String documento) {
        return experienciaRepository.findAllByCodEmp(documento);
    }

    @Override
    public ExperienciaEntity saveNewExperienceEmpleado(String documento, ExperienciaRequest experienciaRequest) {
        Optional<DatosEmpleadoEntity> findDatosEmpleadoByDocumento = datosEmpleadoRepository.findByCodEmp(documento);

        if (findDatosEmpleadoByDocumento.isEmpty()) throw new NotFoundError("El empleado no existe");

        ExperienciaEntity experienciaEntityToSave = new ExperienciaEntity(
                documento,
                experienciaRequest.getNomEmpr(),
                experienciaRequest.getNom_car(),
                experienciaRequest.getArea_exp(),
                experienciaRequest.getDes_fun(),
                experienciaRequest.getTpo_exp(),
                experienciaRequest.getMot_ret(),
                experienciaRequest.getJefe_inm(),
                experienciaRequest.getNum_tel(),
                experienciaRequest.getFec_ing().atStartOfDay(),
                experienciaRequest.getFec_ter().atStartOfDay()
        );

        return experienciaRepository.save(experienciaEntityToSave);
    }

    @Override
    public ExperienciaEntity updateNewExperienceEmpleado(Integer id_experiencia, ExperienciaRequest experienciaRequest) {
        Optional<ExperienciaEntity> findExperienciaById = experienciaRepository.findById(id_experiencia);

        if (findExperienciaById.isEmpty()) throw new NotFoundError("Experiencia no encontrada");

        findExperienciaById.get().setNomEmpr(experienciaRequest.getNomEmpr());
        findExperienciaById.get().setNom_car(experienciaRequest.getNom_car());
        findExperienciaById.get().setArea_exp(experienciaRequest.getArea_exp());
        findExperienciaById.get().setDes_fun(experienciaRequest.getDes_fun());
        findExperienciaById.get().setTpo_exp(experienciaRequest.getTpo_exp());
        findExperienciaById.get().setMot_ret(experienciaRequest.getMot_ret());
        findExperienciaById.get().setJefe_inm(experienciaRequest.getJefe_inm());
        findExperienciaById.get().setNum_tel(experienciaRequest.getNum_tel());
        findExperienciaById.get().setFec_ing(experienciaRequest.getFec_ing().atStartOfDay());
        findExperienciaById.get().setFec_ter(experienciaRequest.getFec_ter().atStartOfDay());

        return experienciaRepository.save(findExperienciaById.get());
    }

    @Override
    public Map<String, String> deleteNewExperienceEmpleado(Integer id_experiencia) {
        Optional<ExperienciaEntity> findExperienciaById = experienciaRepository.findById(id_experiencia);

        if (findExperienciaById.isEmpty()) throw new NotFoundError("Experiencia no encontrada");

        experienciaRepository.delete(findExperienciaById.get());

        return Map.of("message", "Experiencia eliminada correctamente.");
    }
}
