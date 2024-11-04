package com.penagomez.supermario.data.repository;

import com.penagomez.supermario.data.dto.Character;

import java.util.List;

public interface CharacterRepository {
    public List<Character> findAll();
}
