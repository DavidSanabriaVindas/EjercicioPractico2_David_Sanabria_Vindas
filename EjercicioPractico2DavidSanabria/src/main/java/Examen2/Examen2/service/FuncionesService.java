package Examen2.Examen2.service;

import Examen2.Examen2.domain.Funciones;
import java.util.List;

public interface FuncionesService {

    // Devuelve una lista de todas las funciones
    public List<Funciones> getFunciones();

    // Devuelve una función específica por su ID
    public Funciones getFuncion(Funciones funcion);

    // Guarda o actualiza una función
    public void save(Funciones funcion);

    // Elimina una función
    public void delete(Funciones funcion);
}
