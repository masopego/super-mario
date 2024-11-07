package com.penagomez.supermario.data.repository;

import com.penagomez.supermario.data.dto.Character;

import java.util.List;

/**
 * Repository interface for accessing character data.
 * Provides a method to retrieve a list of characters from a data source.
 */
public interface CharacterRepository {

    /**
     * Retrieves all characters available in the data source.
     *
     * @return List of {@link Character} objects.
     */
    List<Character> findAll();
}