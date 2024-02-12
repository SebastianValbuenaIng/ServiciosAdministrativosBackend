package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos.GenPaisesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface GenPaisesRepository extends CrudRepository<GenPaisesEntity, Integer> {
    @Query(value = "select distinct * from novasoft.dbo.gen_paises order by nom_pai", nativeQuery = true)
    List<Map<String, Object>> findAllPaises();

    @Query(value = "select distinct * from novasoft.dbo.gen_deptos where nom_dep <> ''", nativeQuery = true)
    List<Map<String, Object>> findAllDeptos();

    @Query(value = "select distinct * from novasoft.dbo.gen_ciudad order by nom_ciu asc", nativeQuery = true)
    List<Map<String, Object>> findAllCiudades();
}
