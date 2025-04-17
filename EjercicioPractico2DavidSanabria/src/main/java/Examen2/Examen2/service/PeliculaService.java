package Examen2.Examen2.service;

import Examen2.Examen2.domain.Pelicula;
import java.util.List;

public interface PeliculaService {

    // Devuelve una lista de todas las películas
    public List<Pelicula> getPeliculas();

    // Devuelve una película específica por su ID
    public Pelicula getPelicula(Pelicula pelicula);

    // Guarda o actualiza una película
    public void save(Pelicula pelicula);

    // Elimina una película
    public void delete(Pelicula pelicula);
}
