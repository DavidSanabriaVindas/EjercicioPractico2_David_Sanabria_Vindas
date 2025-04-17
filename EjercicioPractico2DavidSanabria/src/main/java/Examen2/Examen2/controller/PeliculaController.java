package Examen2.Examen2.controller;

import Examen2.Examen2.domain.Pelicula;
import Examen2.Examen2.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var peliculas = peliculaService.getPeliculas();
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("totalPeliculas", peliculas.size());
        return "/pelicula/listado";
    }

    @GetMapping("/nuevo")
    public String peliculaNuevo(Pelicula pelicula) {
        return "/pelicula/modifica";
    }

    @PostMapping("/guardar")
    public String peliculaGuardar(Pelicula pelicula) {
        peliculaService.save(pelicula);
        return "redirect:/pelicula/listado";
    }

    @GetMapping("/eliminar/{idPelicula}")
    public String peliculaEliminar(@PathVariable("idPelicula") Long idPelicula) {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(idPelicula);
        peliculaService.delete(pelicula);
        return "redirect:/pelicula/listado";
    }

    @GetMapping("/modificar/{idPelicula}")
    public String peliculaModificar(@PathVariable("idPelicula") Long idPelicula, Model model) {
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(idPelicula);
        pelicula = peliculaService.getPelicula(pelicula);
        model.addAttribute("pelicula", pelicula);
        return "/pelicula/modifica";
    }
}
