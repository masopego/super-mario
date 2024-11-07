package com.penagomez.supermario.ui.handler;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;

import com.google.android.material.navigation.NavigationView;
import com.penagomez.supermario.R;

/**
 * DrawerHandler handles the configuration and behavior of the DrawerLayout and NavigationView,
 * including navigation item selection and drawer visibility toggling.
 */
public class DrawerHandler {

    private final DrawerLayout drawerLayout;
    private final NavController navController;

    private final int NAVIGATION_GRAVITY = GravityCompat.END;

    /**
     * Constructor for DrawerHandler.
     *
     * @param drawerLayout  The DrawerLayout to manage.
     * @param navController The NavController used to navigate between fragments.
     */
    public DrawerHandler(DrawerLayout drawerLayout, NavController navController) {
        this.drawerLayout = drawerLayout;
        this.navController = navController;
    }

    /**
     * Sets up the drawer with the specified NavigationView.
     *
     * @param navigationView The NavigationView to set up with the drawer.
     */
    public void setupDrawer(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    /**
     * Handles navigation item selection within the drawer.
     *
     * @param item The selected menu item within the drawer.
     * @return true if the navigation action was successful; false otherwise.
     */
    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            navController.navigate(R.id.characterListFragment);
        } else if (itemId == R.id.nav_settings) {
            navController.navigate(R.id.preferencesFragment);
        } else {
            throw new IllegalStateException("Unexpected value: " + itemId);
        }
        drawerLayout.closeDrawer(NAVIGATION_GRAVITY);
        return true;
    }

    /**
     * Toggles the visibility of the drawer. Opens it if closed; closes it if open.
     */
    public void toggleDrawer() {
        if (drawerLayout.isDrawerOpen(NAVIGATION_GRAVITY)) {
            drawerLayout.closeDrawer(NAVIGATION_GRAVITY);
        } else {
            drawerLayout.openDrawer(NAVIGATION_GRAVITY);
        }
    }
}