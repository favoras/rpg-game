package com.rpggame.rpgbackend.repository;

import com.rpggame.rpgbackend.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

}
