package Examen2.Examen2.dao;

import Examen2.Examen2.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosDao extends JpaRepository<Usuarios, Long> {

    Usuarios findByNombre(String nombre);

    Usuarios findByNombreAndContrasena(String nombre, String contrasena);

    Usuarios findByNombreOrCorreo(String nombre, String correo);

    boolean existsByNombreOrCorreo(String nombre, String correo);
}
