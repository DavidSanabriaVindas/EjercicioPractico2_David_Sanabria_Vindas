package Examen2.Examen2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="funciones")
public class Funciones implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_funcion")
    private Long idFuncion;
    
    @ManyToOne
    @JoinColumn(name="id_pelicula")
    private Pelicula pelicula;
    
    private String fecha;
    private String hora;
    private String sala;
    
    public Funciones() {
    }
    
    public Funciones(Pelicula pelicula, String fecha, String hora, String sala) {
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
    }
}