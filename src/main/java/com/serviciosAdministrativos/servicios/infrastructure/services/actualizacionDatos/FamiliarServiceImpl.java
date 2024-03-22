package com.serviciosAdministrativos.servicios.infrastructure.services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.AgregarFamiliarRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.FamiliaEmpleadoEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.FamiliaEmpleadoRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.FamiliarService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FamiliarServiceImpl implements FamiliarService {
    private final FamiliaEmpleadoRepository familiaEmpleadoRepository;

    public FamiliarServiceImpl(FamiliaEmpleadoRepository familiaEmpleadoRepository) {
        this.familiaEmpleadoRepository = familiaEmpleadoRepository;
    }

    @Override
    public List<FamiliaEmpleadoEntity> findAllFamiliarByEmpleado(String documento) {
        return familiaEmpleadoRepository.findByCodEmp(documento);
    }

    @Override
    public FamiliaEmpleadoEntity newFamiliarByEmpleado(String documento, AgregarFamiliarRequest agregarFamiliarRequest) {
        FamiliaEmpleadoEntity familiaEmpleadoToSave = new FamiliaEmpleadoEntity(
                documento,
                agregarFamiliarRequest.getApellido_uno_familiar(),
                agregarFamiliarRequest.getApellido_dos_familiar(),
                agregarFamiliarRequest.getNombres_familiar(),
                agregarFamiliarRequest.getParentesco_familiar(),
                agregarFamiliarRequest.getTipo_documento_familiar(),
                agregarFamiliarRequest.getNumero_documento_familiar(),
                agregarFamiliarRequest.getFecha_nacimiento_familiar().atStartOfDay(),
                agregarFamiliarRequest.getGenero_familiar(),
                agregarFamiliarRequest.getEstado_civil_familiar(),
                agregarFamiliarRequest.getNivel_estudios_familiar(),
                agregarFamiliarRequest.getTermino_estudios_familiar(),
                agregarFamiliarRequest.getOcupacion_familiar(),
                agregarFamiliarRequest.getRecibe_sub_familiar(),
                agregarFamiliarRequest.getBeneficiario_pos_familiar(),
                agregarFamiliarRequest.getConvive_conmigo_familiar()
        );

        return familiaEmpleadoRepository.save(familiaEmpleadoToSave);
    }

    @Override
    public FamiliaEmpleadoEntity updateNewFamiliarByEmpleado(Integer id_familiar, AgregarFamiliarRequest agregarFamiliarRequest) {
        Optional<FamiliaEmpleadoEntity> findFamiliarById = familiaEmpleadoRepository.findById(id_familiar);

        if (findFamiliarById.isEmpty()) throw new NotFoundError("Familiar no encontrado");

        findFamiliarById.get().setAp1Fam(agregarFamiliarRequest.getApellido_uno_familiar());
        findFamiliarById.get().setAp2_fam(agregarFamiliarRequest.getApellido_dos_familiar());
        findFamiliarById.get().setNom_fam(agregarFamiliarRequest.getNombres_familiar());
        findFamiliarById.get().setTip_fam(agregarFamiliarRequest.getParentesco_familiar());
        findFamiliarById.get().setTip_ide(agregarFamiliarRequest.getTipo_documento_familiar());
        findFamiliarById.get().setNum_ced(agregarFamiliarRequest.getNumero_documento_familiar());
        findFamiliarById.get().setFec_nac(agregarFamiliarRequest.getFecha_nacimiento_familiar().atStartOfDay());
        findFamiliarById.get().setSex_fam(agregarFamiliarRequest.getGenero_familiar());
        findFamiliarById.get().setEst_civ_fam(agregarFamiliarRequest.getEstado_civil_familiar());
        findFamiliarById.get().setNiv_est(agregarFamiliarRequest.getNivel_estudios_familiar());
        findFamiliarById.get().setInd_comp(agregarFamiliarRequest.getTermino_estudios_familiar());
        findFamiliarById.get().setOcu_fam(agregarFamiliarRequest.getOcupacion_familiar());
        findFamiliarById.get().setInd_sub(agregarFamiliarRequest.getRecibe_sub_familiar());
        findFamiliarById.get().setInd_pro(agregarFamiliarRequest.getBeneficiario_pos_familiar());
        findFamiliarById.get().setInd_conv(agregarFamiliarRequest.getConvive_conmigo_familiar());

        return familiaEmpleadoRepository.save(findFamiliarById.get());
    }

    @Override
    public Map<String, String> deleteNewFamiliarByEmpleado(Integer id_familiar) {
        Optional<FamiliaEmpleadoEntity> findFamiliarById = familiaEmpleadoRepository.findById(id_familiar);

        if (findFamiliarById.isEmpty()) throw new NotFoundError("Familiar no encontrado");

        familiaEmpleadoRepository.delete(findFamiliarById.get());

        return Map.of("message", "Familiar eliminado correctamente.");
    }
}
