package com.serviciosAdministrativos.servicios.infrastructure.services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.AreasInteresEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.AreasInteresRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.AreasInteresService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AreasInteresServiceImpl implements AreasInteresService {
    private final AreasInteresRepository areasInteresRepository;

    public AreasInteresServiceImpl(AreasInteresRepository areasInteresRepository) {
        this.areasInteresRepository = areasInteresRepository;
    }

    @Override
    public List<AreasInteresEntity> getAllAreasInteres(String cod_emp) {
        return areasInteresRepository.findAllByCodEmp(cod_emp);
    }

    @Override
    @Transactional(value = "db4TransactionManager")
    public Map<String, String> postAreasInteres(String cod_emp, List<String> areas_interes) {
        areasInteresRepository.deleteAllByCodEmp(cod_emp);

        areas_interes.forEach(id_interes -> {
            AreasInteresEntity areasInteresEntity = new AreasInteresEntity(
                    cod_emp,
                    Integer.valueOf(id_interes)
            );

            areasInteresRepository.save(areasInteresEntity);
        });

        return Map.of("message", "Areas agregadas exitosamente");
    }
}
