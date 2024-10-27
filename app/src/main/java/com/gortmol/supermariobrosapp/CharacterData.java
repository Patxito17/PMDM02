package com.gortmol.supermariobrosapp;

public class CharacterData {
    // Image resource ID representing the character's image
    private final int image;

    // Name of the character
    private final String name;

    // Description of the character
    private final String description;

    // Abilities of the character
    private final String abilities;

    /**
     * Constructs a new PersonData object with the given parameters.
     *
     * @param image       The resource ID of the character's image.
     * @param name        The name of the character.
     * @param description A short description of the character.
     * @param abilities   The abilities or skills of the character.
     */
    public CharacterData(int image, String name, String description, String abilities) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.abilities = abilities;
    }

    /**
     * Returns the image resource ID of the character.
     *
     * @return The image resource ID.
     */
    public int getImage() {
        return image;
    }

    /**
     * Returns the name of the character.
     *
     * @return The character's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the character.
     *
     * @return The character's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the abilities of the character.
     *
     * @return The character's abilities.
     */
    public String getAbilities() {
        return abilities;
    }
}