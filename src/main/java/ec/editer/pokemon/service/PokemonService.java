/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.editer.pokemon.service;

import ec.editer.pokemon.domain.Pokemon;
import ec.editer.pokemon.repository.IPokemonRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edison Teran
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class PokemonService implements IPokemonService{
    private final IPokemonRepository repository;

    @Override
    public Iterable<Pokemon> todos() {
        return repository.findAll();
    }

    @Override
    public Iterable<Pokemon> buscar(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public Pokemon guardar(Pokemon pokemon) {
        repository.save(pokemon);
        return pokemon;
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Pokemon> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
