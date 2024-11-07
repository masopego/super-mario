package com.penagomez.supermario.ui.handler;


import android.os.Bundle;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.penagomez.supermario.R;
import com.penagomez.supermario.data.dto.Character;

/**
 * NavigationHandler is responsible for managing navigation actions within the application.
 * It handles the setup for navigating to the character details screen with the required data.
 */
public class NavigationHandler {

    private final NavController navController;

    /**
     * Constructor for NavigationHandler.
     *
     * @param navController The NavController used to manage app navigation.
     */
    public NavigationHandler(NavController navController) {
        this.navController = navController;
    }

    /**
     * Navigates to the CharacterDetailFragment with the provided character data.
     *
     * @param character The Character object containing details for the selected character.
     * @param view      The view triggering this navigation event.
     */
    public void navigateToCharacterDetails(Character character, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("image", character.getImage());
        bundle.putString("name", character.getName());
        bundle.putString("description", character.getDescription());
        bundle.putString("abilities", character.getAbilities());
        Navigation.findNavController(view).navigate(R.id.characterDetailsFragment, bundle);
    }
}