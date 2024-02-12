package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos.GTHEstadoCivilEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface GTHEstadoCivilRepository extends CrudRepository<GTHEstadoCivilEntity, Integer> {
    @Query(value = "select * from novasoft.dbo.rhh_cargos order by nom_car asc", nativeQuery = true)
    List<Map<String, Object>> findAllCargos();

    @Query(value = "select * from novasoft.dbo.gen_tipide", nativeQuery = true)
    List<Map<String, Object>> findAllTipoDocumento();

    @Query(value = "select a.cod_emp, LTRIM(RTRIM(a.ap1_emp)) + ' ' + LTRIM(RTRIM(a.ap2_emp)) + ' ' + LTRIM(RTRIM(a.nom_emp)) AS nombres, f.des_tip as tipo_doc, cod_emp, convert(varchar(10), fec_nac, 103) fecha_nacimiento, des_gen, dir_res, tel_res, tel_cel tel_celular, e_mail email, a.e_mail_alt as email_alterno, CASE a.clasif_cat WHEN 00 THEN 'Profesor sin categorizar' WHEN 01 THEN 'Profesor instructor' WHEN 02 THEN 'Profesor asistente' WHEN 03 THEN 'Profesor asociado' WHEN 04 THEN 'Profesor titular' WHEN 05 THEN 'Instructor' WHEN 06 THEN 'Profesor especial' WHEN 07 THEN 'Fuera de escalafon' WHEN 08 THEN 'Insctructor B.U' WHEN 21 THEN 'Administrativo' END AS categoria, d.des_est as estado_civil, e.NOMBRE as tipo_empleado, g.nom_pai as pais_residencia, dd.nom_dep as depto_res, ciud.nom_ciu from Nova_pruebas.dbo.rhh_emplea a left outer join Nova_pruebas.dbo.gen_ciudad b on (a.ciu_res = b.cod_ciu and a.cod_pai = b.cod_pai) left outer join Nova_pruebas.dbo.GTH_Genero c on (a.sex_emp = c.cod_gen) left outer join Nova_pruebas.dbo.GTH_EstCivil d on (a.est_civ = d.cod_est) left outer join Nova_pruebas.dbo.gen_clasif4 e on (a.cod_cl4 = e.CODIGO) left outer join Nova_pruebas.dbo.gen_tipide f on (a.tip_ide = f.cod_tip) left outer join Nova_pruebas.dbo.gen_paises g on (a.pai_res = g.cod_pai) left outer join Nova_pruebas.dbo.gen_deptos dd on (a.dpt_res = dd.cod_dep) and (a.pai_res = dd.cod_pai) left outer join Nova_pruebas.dbo.gen_ciudad ciud on (a.ciu_res = ciud.cod_ciu) and (a.dpt_res = ciud.cod_dep) and (a.pai_res = ciud.cod_pai) where a.cod_emp = :documento", nativeQuery = true)
    Map<String, Object> getInformacionEmpleado(String documento);
}
