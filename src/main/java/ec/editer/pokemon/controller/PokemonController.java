/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.editer.pokemon.controller;

import ec.editer.pokemon.domain.Pokemon;
import ec.editer.pokemon.service.IPokemonService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edison Teran
 */
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    private final IPokemonService service;
    
    @GetMapping("/todos")
    public ResponseEntity<Iterable<Pokemon>> todos(){
        return ResponseEntity.ok(service.todos());
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<Iterable<Pokemon>> buscar(@RequestParam("nombre") String nombre){
        if(nombre.isEmpty()){
            return ResponseEntity.ok(service.todos());
        }else{
            return ResponseEntity.ok(service.buscar(nombre));
        }        
    }
    
    @PostMapping("/guardar")
    public ResponseEntity<Pokemon> guardar(@RequestBody Pokemon pokemon){
        return ResponseEntity.ok(service.guardar(pokemon));
    }
    
    @PutMapping("/actualizar")
    public ResponseEntity<Pokemon> actualizar(@RequestBody Pokemon pokemon){
        return ResponseEntity.ok(service.guardar(pokemon));
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable("id") Long id){
        service.eliminar(id);
        return ResponseEntity.ok(true);
    }
    
    @GetMapping("/buscarPorId")
    public ResponseEntity<Optional<Pokemon>> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}
