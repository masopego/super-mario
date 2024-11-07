package com.penagomez.supermario.data.dto;

/**
 * Data Transfer Object (DTO) representing a character.
 * Holds essential information about a character, including image, name, description, and abilities.
 */
public class Character {

    // Resource ID of the character's image.
    private final int image;

    // Name of the character.
    private final String name;

    // Brief description of the character.
    private final String description;

    // List of abilities or special skills of the character.
    private final String abilities;

    /**
     * Constructs a Character with the specified image, name, description, and abilities.
     *
     * @param image       Resource ID for the character's image.
     * @param name        Name of the character.
     * @param description Short description of the character.
     * @param abilities   Abilities or skills of the character.
     */
    public Character(int image, String name, String description, String abilities) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.abilities = abilities;
    }

    /**
     * Gets the image resource ID of the character.
     *
     * @return Image resource ID as an integer.
     */
    public int getImage() {
        return image;
    }

    /**
     * Gets the name of the character.
     *
     * @return Character's name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the character.
     *
     * @return Character's description as a String.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the abilities of the character.
     *
     * @return Character's abilities as a String.
     */
    public String getAbilities() {
        return abilities;
    }
}