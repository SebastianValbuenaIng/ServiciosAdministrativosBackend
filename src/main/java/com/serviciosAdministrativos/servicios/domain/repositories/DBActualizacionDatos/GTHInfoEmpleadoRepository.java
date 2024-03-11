package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos.GTHEstadoCivilEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface GTHInfoEmpleadoRepository extends CrudRepository<GTHEstadoCivilEntity, Integer> {
    @Query(value = "select * from Nova_pruebas.dbo.rhh_cargos order by nom_car asc", nativeQuery = true)
    List<Map<String, Object>> findAllCargos();

    @Query(value = "select * from novasoft.dbo.gen_tipide", nativeQuery = true)
    List<Map<String, Object>> findAllTipoDocumento();

    @Query(value = "select * from nova_pruebas.dbo.gen_parentesco", nativeQuery = true)
    List<Map<String, Object>> getParentesco();

    @Query(value = "SELECT * FROM Novasoft.dbo.GTH_Ocupacion", nativeQuery = true)
    List<Map<String, Object>> getOcupacion();

    @Query(value = "SELECT * FROM Novasoft.dbo.rhh_tbidioma", nativeQuery = true)
    List<Map<String, Object>> getIdiomas();

    @Query(value = "SELECT * FROM Novasoft.dbo.GTH_IdiomaHabilidad", nativeQuery = true)
    List<Map<String, Object>> getHabilidad();

    @Query(value = "SELECT * FROM Novasoft.dbo.GTH_Calificacion", nativeQuery = true)
    List<Map<String, Object>> getCalificacion();

    @Query(value = "SELECT * FROM Novasoft.dbo.GTH_ExpLabTpo", nativeQuery = true)
    List<Map<String, Object>> getDuracionExperiencia();

    @Query(value = "SELECT * FROM Novasoft.dbo.GTH_ExpLabArea", nativeQuery = true)
    List<Map<String, Object>> getAreasExperiencia();

    @Query(value = "SELECT * FROM Novasoft.dbo.rhh_tbclaest", nativeQuery = true)
    List<Map<String, Object>> getNivelEstudios();

    @Query(value = "select a.cod_emp, LTRIM(RTRIM(a.ap1_emp)) + ' ' + LTRIM(RTRIM(a.ap2_emp)) + ' ' + LTRIM(RTRIM(a.nom_emp)) AS nombres, f.des_tip as tipo_doc, cod_emp, convert(varchar(10), fec_nac, 103) fecha_nacimiento, des_gen, dir_res, tel_res, tel_cel tel_celular, e_mail email, a.e_mail_alt as email_alterno, CASE a.clasif_cat WHEN 00 THEN 'Profesor sin categorizar' WHEN 01 THEN 'Profesor instructor' WHEN 02 THEN 'Profesor asistente' WHEN 03 THEN 'Profesor asociado' WHEN 04 THEN 'Profesor titular' WHEN 05 THEN 'Instructor' WHEN 06 THEN 'Profesor especial' WHEN 07 THEN 'Fuera de escalafon' WHEN 08 THEN 'Insctructor B.U' WHEN 21 THEN 'Administrativo' END AS categoria, d.des_est as estado_civil, e.NOMBRE as tipo_empleado, g.nom_pai as pais_residencia, dd.nom_dep as depto_res, ciud.nom_ciu from Nova_pruebas.dbo.rhh_emplea a left outer join Nova_pruebas.dbo.gen_ciudad b on (a.ciu_res = b.cod_ciu and a.cod_pai = b.cod_pai) left outer join Nova_pruebas.dbo.GTH_Genero c on (a.sex_emp = c.cod_gen) left outer join Nova_pruebas.dbo.GTH_EstCivil d on (a.est_civ = d.cod_est) left outer join Nova_pruebas.dbo.gen_clasif4 e on (a.cod_cl4 = e.CODIGO) left outer join Nova_pruebas.dbo.gen_tipide f on (a.tip_ide = f.cod_tip) left outer join Nova_pruebas.dbo.gen_paises g on (a.pai_res = g.cod_pai) left outer join Nova_pruebas.dbo.gen_deptos dd on (a.dpt_res = dd.cod_dep) and (a.pai_res = dd.cod_pai) left outer join Nova_pruebas.dbo.gen_ciudad ciud on (a.ciu_res = ciud.cod_ciu) and (a.dpt_res = ciud.cod_dep) and (a.pai_res = ciud.cod_pai) where a.cod_emp = :documento", nativeQuery = true)
    Map<String, Object> getInformacionEmpleado(String documento);

    @Query(value = "select cod_redsoc as codigo, usuario from Nova_pruebas.dbo.GTH_EmpRedSocial where cod_emp= :documento", nativeQuery = true)
    List<Map<String, Object>> findRedesSocialesByDocumento(String documento);

    @Query(value = "SELECT rtrim(estu.nom_est) + '-' + rtrim(inst.nom_ins) + '-' + CAST(estu.ano_est AS VARCHAR) AS institucion, estu.tip_est FROM Novasoft.dbo.rhh_estudio AS estu JOIN Novasoft.dbo.rhh_tbinsti AS inst ON inst.cod_ins = estu.cod_ins WHERE estu.cod_emp = :documento AND estu.tip_est NOT IN ('0', '09', '80', '30', '35', '40')", nativeQuery = true)
    List<Map<String, Object>> findTitulosByDocumento(String documento);

    @Query(value = "select b.nombre as area, d.nom_car cargo ,c.usr_num_ext extension, c.ubicacion from Nova_pruebas.dbo.rhh_emplea a inner join Nova_pruebas.dbo.gen_clasif1 b on (a.cod_cl1 = b.codigo) left outer join Nova_pruebas.dbo.USR_RHH_EMPLEA c on (a.cod_emp = c.Cod_emp) left outer join Nova_pruebas.dbo.rhh_cargos d on (a.cod_car = d.cod_car) where a.cod_emp= :documento", nativeQuery = true)
    Map<String, Object> getDetallesCargoByDocumento(String documento);

    @Query(value = "SELECT nom_empr, NOM_CAR, des_fun, b.des_area_exp, c.des_tpo_exp duracion, a.mot_ret, a.jefe_inm, a.num_tel, a.fec_ing, a.fec_ter FROM Novasoft.dbo.GTH_ExpLaboralEmp a inner join Novasoft.dbo.GTH_ExpLabArea b on (a.area_exp = b.area_exp) inner join Novasoft.dbo.GTH_ExpLabTpo c on (a.tpo_exp = c.tpo_exp) WHERE cod_emp = :documento", nativeQuery = true)
    List<Map<String, Object>> getExperienciaEmpleadoByDocumento(String documento);

    @Query(value = "SELECT a.cod_emp, b.nom_idi, d.Txt_Calif, c.Des_habilidad FROM  Novasoft.dbo.rhh_idioma a inner join Novasoft.dbo.rhh_tbidioma b on (a.cod_idi = b.cod_idi) left outer join Novasoft.dbo.GTH_IdiomaHabilidad c on (a.cod_hab = c.Cod_habilidad) left outer join Novasoft.dbo.GTH_Calificacion d on (a.cod_calif = d.cod_calif) WHERE cod_emp = :documento", nativeQuery = true)
    List<Map<String, Object>> getIdiomasEmpleadoByDocumento(String documento);

    @Query(value = "SELECT a.cod_emp,a.ap1_fam as primer_apell,a.ap2_fam as seg_apell,a.nom_fam as nombres,b.nom_par,c.des_tip as tipo_doc,a.num_ced as documento,convert(varchar(10), a.fec_nac, 103) as fech_nac,d.des_gen,e.des_est,f.des_ocu,case a.ind_sub when '1' then 'Si' else 'No' end as recibe_sub, IIF(a.ind_pro = '1', 'Si', 'No') as benef_pos, IIF(a.ind_conv = '1', 'Si', 'No') as convive_conmigo,g.des_est as niv_estudio, IIF(a.ind_comp = '1', 'Si', 'No') as termino_estudios FROM Nova_pruebas.dbo.rhh_familia a left outer join Nova_pruebas.dbo.gen_parentesco b on (a.tip_fam = b.cod_par) left outer join Nova_pruebas.dbo.gen_tipide c on (a.tip_ide = c.cod_tip) left outer join Nova_pruebas.dbo.GTH_Genero d on (a.sex_fam = d.cod_gen) left outer join Nova_pruebas.dbo.GTH_EstCivil e on (a.est_civ = e.cod_est) left outer join Nova_pruebas.dbo.GTH_Ocupacion f on (a.ocu_fam = f.cod_ocu) left outer join Nova_pruebas.dbo.rhh_tbclaest g on (a.niv_est = g.tip_est) where cod_emp = :documento", nativeQuery = true)
    List<Map<String, Object>> getFamiliaresEmpleadoByDocumento(String documento);

    @Query(value = "select a.cod_emp, id_interes,  DESCRIPCION from Novasoft.dbo.rhh_emplea a inner join Novasoft.dbo.USR_GTH_TBINTERES b on (a.cod_cl1 = b.cod_cl1) where a.cod_emp= :documento", nativeQuery = true)
    List<Map<String, Object>> getAreaInteresEmpleadoByDocumento(String documento);

    @Query(value = "select * from Novasoft.dbo.USR_GTH_PERFILHV where cod_emp = :documento", nativeQuery = true)
    Map<String, Object> getPerfilWebEmpleadoByDocumento(String documento);

    @Query(value = "SELECT distinct PUB.DESCRIP FROM Novasoft.dbo.rhh_anexosemplea AS PUB WHERE PUB.cod_emp = :documento", nativeQuery = true)
    List<Map<String, Object>> getPublicacionEmpleadoByDocumento(String documento);

    @Query(value = "select cod_est,nom_est from Novasoft.dbo.rhh_tbestud where tip_est in (01,02,03,04,05,06) order by 2", nativeQuery = true)
    List<Map<String, Object>> getEstudios();

    @Query(value = "select cod_ins,nom_ins from Novasoft.dbo.rhh_tbinsti order by 2", nativeQuery = true)
    List<Map<String, Object>> getInstituciones();
}