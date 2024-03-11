package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.TitulosEmpleadoEntity;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface PerfilEmpleadoService {
    List<TitulosEmpleadoEntity> findAllTitulosPregrado(String documento);
    TitulosEmpleadoEntity newTituloEmpleado(String nombre,
                                            String documento,
                                            String cod_estudio,
                                            MultipartFile[] archivo,
                                            String cod_ins,
                                            Integer ano_est,
                                            LocalDate fec_gra,
                                            String nro_tar);
    void getTituloDocumento(String fileName, HttpServletResponse response);
    Map<String, String> deleteTituloEmpleado(Integer id_titulo);
    TitulosEmpleadoEntity updateTituloEmpleado(Integer id_titulo,
                                               String nombre,
                                               String cod_estudio,
                                               MultipartFile[] archivo,
                                               String cod_ins,
                                               Integer ano_est,
                                               LocalDate fec_gra,
                                               String nro_tar);
}
