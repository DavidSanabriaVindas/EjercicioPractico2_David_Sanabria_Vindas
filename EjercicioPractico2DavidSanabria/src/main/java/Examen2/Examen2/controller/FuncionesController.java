package Examen2.Examen2.controller;

import Examen2.Examen2.domain.Funciones;
import Examen2.Examen2.service.FuncionesService;
import Examen2.Examen2.domain.Pelicula;
import Examen2.Examen2.service.PeliculaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funciones")  
public class FuncionesController {
    
    @Autowired
    private FuncionesService funcionesService;
    
    @Autowired
    private PeliculaService peliculaService;
    
    @GetMapping({"", "/"})
    public String redirigirAListado() {
        return "redirect:/funciones/listado";
    }


    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Funciones> funciones = funcionesService.getFunciones();
        model.addAttribute("funciones", funciones);
        model.addAttribute("totalFunciones", funciones.size());
        model.addAttribute("funcion", new Funciones()); 
        return "/funciones/listado";  
    }
    
    @GetMapping("/nueva")
    public String nuevaFuncion(Funciones funcion, Model model) {
        model.addAttribute("funcion", funcion); 
        var peliculas = peliculaService.getPeliculas();
        model.addAttribute("peliculas", peliculas);
        return "/funciones/modifica";  
    }
    
    @PostMapping("/guardar")
    public String guardarFuncion(Funciones funcion) {
        funcionesService.save(funcion);
        return "redirect:/funciones/listado";  
    }
    
    @GetMapping("/eliminar/{idFuncion}")
    public String eliminarFuncion(@PathVariable("idFuncion") Long idFuncion) {
        Funciones funcion = new Funciones(); 
        funcion.setIdFuncion(idFuncion);
        funcionesService.delete(funcion);
        return "redirect:/funciones/listado";  
    }
    
    @GetMapping("/modificar/{idFuncion}")
    public String modificarFuncion(@PathVariable("idFuncion") Long idFuncion, Model model) {
        Funciones funcion = new Funciones();
        funcion.setIdFuncion(idFuncion);
        funcion = funcionesService.getFuncion(funcion);
        model.addAttribute("funcion", funcion);
        
        var peliculas = peliculaService.getPeliculas();
        model.addAttribute("peliculas", peliculas);
        
        return "/funciones/modifica";  
    }
}