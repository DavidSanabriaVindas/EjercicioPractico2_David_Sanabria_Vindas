package Examen2.Examen2.service;

import Examen2.Examen2.domain.Usuarios;
import java.util.List;

public interface UsuariosService {

    // Se obtiene un listado de usuarios en un List
    public List<Usuarios> getUsuarios();
    
    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuarios getUsuario(Usuarios usuario);
    
    // Se obtiene un Usuario, a partir del correo del usuario
    public Usuarios getUsuarioPorCorreo(String correo);

    // Se obtiene un Usuario, a partir del correo y la contraseña
    public Usuarios getUsuarioPorCorreoYPassword(String correo, String password);
    
    // Se valida si existe un Usuario considerando el correo
    public boolean existeUsuarioPorCorreo(String correo);
    
    // Se inserta un nuevo usuario si el id del usuario está vacío
    // Se actualiza un usuario si el id del usuario NO está vacío
    public void save(Usuarios usuario, boolean crearRolUser);
    
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuarios usuario);
}
