package com.penagomez.supermario.data.repository;

import android.content.Context;

import com.penagomez.supermario.R;
import com.penagomez.supermario.data.dto.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * InMemoryCharacterRepository is an implementation of the CharacterRepository interface.
 * This repository is used to provide a list of characters stored in memory.
 * It populates the list of characters using hardcoded values (images and character details)
 * and retrieves the list when requested.
 */
public class InMemoryCharacterRepository implements CharacterRepository {

    // List of characters stored in memory
    private List<Character> characters = new ArrayList<>();
    private Context context;

    /**
     * Constructor to initialize the repository with context.
     * The context is used to fetch string resources for character details.
     *
     * @param context The application context, used to fetch strings and resources.
     */
    public InMemoryCharacterRepository(Context context) {

        this.context = context;

        // Adds hardcoded character details to the list
        characters.add(
                new Character(
                        R.drawable.mario,
                        context.getString(R.string.mario_name),
                        context.getString(R.string.mario_description),
                        context.getString(R.string.mario_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.luigi,
                        context.getString(R.string.luigi_name),
                        context.getString(R.string.luigi_description),
                        context.getString(R.string.luigi_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.peach,
                        context.getString(R.string.peach_name),
                        context.getString(R.string.peach_description),
                        context.getString(R.string.peach_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.bowser,
                        context.getString(R.string.bowser_name),
                        context.getString(R.string.bowser_description),
                        context.getString(R.string.bowser_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.yoshi,
                        context.getString(R.string.yoshi_name),
                        context.getString(R.string.yoshi_description),
                        context.getString(R.string.yoshi_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.toad,
                        context.getString(R.string.toad_name),
                        context.getString(R.string.toad_description),
                        context.getString(R.string.toad_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.donkey_kong,
                        context.getString(R.string.donkey_kong_name),
                        context.getString(R.string.donkey_kong_description),
                        context.getString(R.string.donkey_kong_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.wario,
                        context.getString(R.string.wario_name),
                        context.getString(R.string.wario_description),
                        context.getString(R.string.wario_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.waluigi,
                        context.getString(R.string.waluigi_name),
                        context.getString(R.string.waluigi_description),
                        context.getString(R.string.waluigi_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.daisy,
                        context.getString(R.string.daisy_name),
                        context.getString(R.string.daisy_description),
                        context.getString(R.string.daisy_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.koopa_troopa,
                        context.getString(R.string.koopa_troopa_name),
                        context.getString(R.string.koopa_troopa_description),
                        context.getString(R.string.koopa_troopa_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.goomba,
                        context.getString(R.string.goomba_name),
                        context.getString(R.string.goomba_description),
                        context.getString(R.string.goomba_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.bowserjr,
                        context.getString(R.string.bowser_jr_name),
                        context.getString(R.string.bowser_jr_description),
                        context.getString(R.string.bowser_jr_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.rosalina,
                        context.getString(R.string.rosalina_name),
                        context.getString(R.string.rosalina_description),
                        context.getString(R.string.rosalina_skills)
                )
        );
        characters.add(
                new Character(
                        R.drawable.lakitu,
                        context.getString(R.string.lakitu_name),
                        context.getString(R.string.lakitu_description),
                        context.getString(R.string.lakitu_skills)
                )
        );
    }

    /**
     * Retrieves the list of all characters in the repository.
     *
     * @return A list of {@link Character} objects.
     */
    @Override
    public List<Character> findAll() {
        return characters;
    }
}
