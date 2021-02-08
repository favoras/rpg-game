package com.rpggame.rpgbackend.controller;


import com.rpggame.rpgbackend.exception.CharacterNotFoundException;
import com.rpggame.rpgbackend.model.Character;
import com.rpggame.rpgbackend.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping("/characters")
    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    @PostMapping("/characters")
    public Character createCharacter(@RequestBody Character character){
        return characterRepository.save(character);
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id){
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("Character not found with id: " + id));
        return ResponseEntity.ok(character);
    }

    @PutMapping("/characters/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character characterDetails){
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("Character not found with id: " + id));

        character.setNickname(characterDetails.getNickname());

        Character updatedCharacter = characterRepository.save(character);

        return ResponseEntity.ok(updatedCharacter);
    }

    @DeleteMapping("/characters/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCharacter(@PathVariable Long id){
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("Character not found with id: " + id));

        characterRepository.delete(character);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
