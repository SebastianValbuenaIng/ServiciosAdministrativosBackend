package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.DatosEmpleadoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DatosEmpleadoRepository extends CrudRepository<DatosEmpleadoEntity, Integer> {
    Optional<DatosEmpleadoEntity> findByCodEmp(String documento);

    @Query(value = "select *, a.cod_emp as cod_emp_principal from ACTUALIZA_DATOS_PERS.dbo.Datos_Empleado a left outer join ACTUALIZA_DATOS_PERS.dbo.Redes_Sociales b on (a.cod_emp = b.cod_emp) left outer join ACTUALIZA_DATOS_PERS.dbo.Familia_Empleado c on (a.cod_emp = c.cod_emp) left outer join ACTUALIZA_DATOS_PERS.dbo.Experiencia d on (a.cod_emp = d.cod_emp) left outer join ACTUALIZA_DATOS_PERS.dbo.Idiomas e on (a.cod_emp = e.cod_emp) left outer join ACTUALIZA_DATOS_PERS.dbo.Areas_Interes f on (a.cod_emp = f.cod_emp) left outer join ACTUALIZA_DATOS_PERS.dbo.Perfil_Web g on (a.cod_emp = g.cod_emp) left outer join ACTUALIZA_DATOS_PERS.dbo.Titulos_Empleado h on (a.cod_emp = h.cod_emp) left outer join ACTUALIZA_DATOS_PERS.dbo.Publicaciones i on (a.cod_emp = i.cod_emp)", nativeQuery = true)
    List<Map<String, Object>> selectAllTablesActualizaDatosPers();
}
