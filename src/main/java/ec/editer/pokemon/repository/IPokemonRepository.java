/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.editer.pokemon.repository;

import ec.editer.pokemon.domain.Pokemon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Edison Teran
 */
public interface IPokemonRepository extends CrudRepository<Pokemon, Long>{
    @Query("select p from Pokemon p where p.nombre like concat(?1,'%')")
    Iterable<Pokemon> findByNombre(String nombre);
}
