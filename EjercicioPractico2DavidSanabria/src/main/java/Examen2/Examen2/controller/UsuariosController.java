package Examen2.Examen2.controller;

import Examen2.Examen2.domain.Usuarios;
import Examen2.Examen2.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuariosController {
    
    @Autowired
    private UsuariosService usuariosService;
    
    // Listado de usuarios
    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = usuariosService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuario/listado";
    }
    
    // Página para crear un nuevo usuario
    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuarios usuario) {
        return "/usuario/modifica";
    }
    
    // Guardar un nuevo usuario o modificar uno existente
    @PostMapping("/guardar")
    public String usuarioGuardar(Usuarios usuario) {
        // El segundo parámetro (true) indica que se creará el rol USER al guardar
        usuariosService.save(usuario, true);
        return "redirect:/usuario/listado";
    }
    
    // Eliminar un usuario
    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(@PathVariable("idUsuario") Long idUsuario) {
        Usuarios usuario = new Usuarios();
        usuario.setIdUsuario(idUsuario);
        usuariosService.delete(usuario);
        return "redirect:/usuario/listado";
    }
    
    // Modificar un usuario
    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(@PathVariable("idUsuario") Long idUsuario, Model model) {
        Usuarios usuario = new Usuarios();
        usuario.setIdUsuario(idUsuario);
        usuario = usuariosService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}
