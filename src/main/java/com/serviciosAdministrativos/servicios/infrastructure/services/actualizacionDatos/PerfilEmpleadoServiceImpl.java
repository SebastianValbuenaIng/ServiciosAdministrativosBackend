package com.serviciosAdministrativos.servicios.infrastructure.services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.TitulosEmpleadoEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.TitulosEmpleadoRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.PerfilEmpleadoService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.ServerError;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

@Service
public class PerfilEmpleadoServiceImpl implements PerfilEmpleadoService {
    private final Environment environment;
    private final TitulosEmpleadoRepository titulosEmpleadoRepository;

    public PerfilEmpleadoServiceImpl(Environment environment,
                                     TitulosEmpleadoRepository titulosEmpleadoRepository) {
        this.environment = environment;
        this.titulosEmpleadoRepository = titulosEmpleadoRepository;
    }

    @Override
    public List<TitulosEmpleadoEntity> findAllTitulosPregrado(String documento) {
        return titulosEmpleadoRepository.findAllByCodEmp(documento);
    }

    @Override
    public TitulosEmpleadoEntity newTituloEmpleado(String nombre,
                                                   String documento,
                                                   String cod_estudio,
                                                   MultipartFile[] archivo,
                                                   String cod_ins,
                                                   Integer ano_est,
                                                   LocalDate fec_gra,
                                                   String nro_tar) {
        TitulosEmpleadoEntity titulosEmpleadoToSave = new TitulosEmpleadoEntity();
        titulosEmpleadoToSave.setCodEmp(documento);

        Optional<TitulosEmpleadoEntity> lastTituloEmpleado = titulosEmpleadoRepository.findLastTitulosEmpleadoById(documento);

        MultipartFile file = Arrays.stream(archivo).findFirst().orElseThrow();

        String tituloFileOriginalName = file.getOriginalFilename();

        if (file.getSize() > 10 * 1024 * 1024)
            throw new ServerError("El archivo debe ser menor de 10 MB");

        assert tituloFileOriginalName != null;
        if (!tituloFileOriginalName.endsWith(".pdf"))
            throw new ServerError("Solo se permiten archivos con extensión .pdf");

        String fileFileExtension = tituloFileOriginalName
                .substring(tituloFileOriginalName.lastIndexOf("."));

        String newFileNameDB;

        newFileNameDB = lastTituloEmpleado.map(titulosEmpleadoEntity ->
                nombre + "-" + (titulosEmpleadoEntity.getId() + 1) + fileFileExtension).orElseGet(() -> nombre + fileFileExtension);

        // Ruta para guardar el archivo
        Path pathSaveFile = Paths.get(Objects.requireNonNull(environment
                .getProperty("route.documents.uploads")).concat("\\") + newFileNameDB);

        // Guardar el archivo
        try {
            Files.write(pathSaveFile, file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        titulosEmpleadoToSave.setCod_estudio(cod_estudio);
        titulosEmpleadoToSave.setCod_ins(cod_ins);
        titulosEmpleadoToSave.setArchivo(newFileNameDB);
        titulosEmpleadoToSave.setCodEmp(documento);
        titulosEmpleadoToSave.setFec_gra(fec_gra.toString());
        titulosEmpleadoToSave.setNro_tar(nro_tar != null ? nro_tar.trim().isEmpty() ? null : nro_tar : null);
        titulosEmpleadoToSave.setAno_est(ano_est);

        return titulosEmpleadoRepository.save(titulosEmpleadoToSave);
    }

    @Override
    public void getTituloDocumento(String fileName, HttpServletResponse response) {
        try {
            String path = Objects.requireNonNull(
                    environment.getProperty("route.documents.uploads")).concat("\\") + fileName;

            byte[] bytes = Files.readAllBytes(Paths.get(path));

            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.close();

            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        } catch (Exception e) {
            throw new ServerError("No existe un documento con ese nombre");
        }
    }

    @Override
    @Transactional(value = "db4TransactionManager")
    public Map<String, String> deleteTituloEmpleado(Integer id_titulo) {
        Optional<TitulosEmpleadoEntity> findTituloEmpleadoById = titulosEmpleadoRepository.findById(id_titulo);

        if (findTituloEmpleadoById.isEmpty()) throw new NotFoundError("El titulo no existe");

        Path deleteFile = Paths.get(Objects.requireNonNull(
                        environment.getProperty("route.documents.uploads"))
                                            .concat("\\") + findTituloEmpleadoById.get().getArchivo());
        try {
            Files.delete(deleteFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


        titulosEmpleadoRepository.delete(findTituloEmpleadoById.get());

        return Map.of("message", "El titulo se eliminó correctamente");
    }

    @Override
    public TitulosEmpleadoEntity updateTituloEmpleado(
            Integer id_titulo,
            String nombre,
            String cod_estudio,
            MultipartFile[] archivo,
            String cod_ins,
            Integer ano_est,
            LocalDate fec_gra,
            String nro_tar) {

        Optional<TitulosEmpleadoEntity> findTituloEmpleadoById = titulosEmpleadoRepository.findById(id_titulo);

        if (findTituloEmpleadoById.isEmpty()) throw new NotFoundError("El titulo no existe");

        if (archivo != null) {
            // Eliminar archivo titulo
            Path deleteFile = Paths.get(Objects.requireNonNull(
                            environment.getProperty("route.documents.uploads"))
                                                .concat("\\") + findTituloEmpleadoById.get().getArchivo());
            try {
                Files.delete(deleteFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }

            // Guardar nuevo archivo
            MultipartFile file = Arrays.stream(archivo).findFirst().orElseThrow();

            String tituloFileOriginalName = file.getOriginalFilename();

            if (file.getSize() > 10 * 1024 * 1024)
                throw new ServerError("El archivo debe ser menor de 10 MB");

            assert tituloFileOriginalName != null;
            if (!tituloFileOriginalName.endsWith(".pdf"))
                throw new ServerError("Solo se permiten archivos con extensión .pdf");

            // Ruta para guardar el archivo
            Path pathSaveFile = Paths.get(Objects.requireNonNull(environment
                    .getProperty("route.documents.uploads")).concat("\\") + findTituloEmpleadoById.get().getArchivo());

            // Guardar el archivo
            try {
                Files.write(pathSaveFile, file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        findTituloEmpleadoById.get().setCod_estudio(cod_estudio);
        findTituloEmpleadoById.get().setCod_ins(cod_ins);
        findTituloEmpleadoById.get().setAno_est(ano_est);
        findTituloEmpleadoById.get().setFec_gra(fec_gra.toString());
        findTituloEmpleadoById.get().setNro_tar(nro_tar != null ? nro_tar.trim().isEmpty() ? null : nro_tar : null);

        return titulosEmpleadoRepository.save(findTituloEmpleadoById.get());
    }
}