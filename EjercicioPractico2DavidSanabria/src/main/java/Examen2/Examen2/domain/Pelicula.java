package Examen2.Examen2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="peliculas")
public class Pelicula implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pelicula")
    private Long idPelicula;
    private String titulo;
    private String tipo;
    
    @OneToMany
    @JoinColumn(name = "id_pelicula", updatable = false)
    List<Funciones> funciones;
    
    public Pelicula() {
    }
    
    public Pelicula(String titulo, String tipo) {
        this.titulo = titulo;
        this.tipo = tipo;
    }
}