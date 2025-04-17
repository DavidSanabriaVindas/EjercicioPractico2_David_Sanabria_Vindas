package Examen2.Examen2.service.impl;

import Examen2.Examen2.dao.UsuariosDao;
import Examen2.Examen2.domain.Usuarios;
import Examen2.Examen2.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosDao usuariosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> getUsuarios() {
        return usuariosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuario(Usuarios usuario) {
        return usuariosDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorCorreo(String correo) {
        // Cambiado para usar el método correcto de usuariosDao
        return usuariosDao.findByNombreOrCorreo(null, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarioPorCorreoYPassword(String correo, String contrasena) {
        // Cambiado para usar el método correcto de usuariosDao
        return usuariosDao.findByNombreAndContrasena(null, contrasena);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorCorreo(String correo) {
        // Cambiado para usar el método correcto de usuariosDao
        return usuariosDao.existsByNombreOrCorreo(null, correo);
    }

    @Override
    @Transactional
    public void save(Usuarios usuario, boolean crearRolUser) {
        if (usuario.getIdUsuario() == null) {
            // Si el usuario no tiene un id, se inserta un nuevo usuario
            usuariosDao.save(usuario);
        } else {
            // Si ya existe un id, actualiza el usuario
            usuariosDao.save(usuario);
        }
    }

    @Override
    @Transactional
    public void delete(Usuarios usuario) {
        usuariosDao.delete(usuario);
    }
}
