/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.editer.pokemon.service;

import ec.editer.pokemon.domain.Pokemon;
import java.util.Optional;

/**
 *
 * @author Edison Teran
 */
public interface IPokemonService {
    Iterable<Pokemon> todos();
    Iterable<Pokemon> buscar(String nombre);
    Optional<Pokemon> buscarPorId(Long id);
    Pokemon guardar(Pokemon pokemon);
    void eliminar(Long id);
}
