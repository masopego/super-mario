package com.penagomez.supermario.ui;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.penagomez.supermario.R;
import com.penagomez.supermario.data.dto.Character;
import com.penagomez.supermario.databinding.ActivityMainBinding;
import com.penagomez.supermario.ui.handler.DrawerHandler;
import com.penagomez.supermario.ui.handler.MenuHandler;
import com.penagomez.supermario.ui.handler.NavigationHandler;

/**
 * MainActivity serves as the main entry point of the application, initializing UI components
 * and coordinating user interactions.
 * <p>
 * Responsibilities are delegated to handlers for better readability:
 * - NavigationHandler manages fragment navigation.
 * - MenuHandler manages the options menu and the "About" dialog.
 * - DrawerHandler manages the drawer layout and navigation within it.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NavController navController;
    private DrawerHandler drawerHandler;
    private MenuHandler menuHandler;
    private NavigationHandler navigationHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController);

        drawerHandler = new DrawerHandler(binding.drawerLayout, navController);
        menuHandler = new MenuHandler(this);
        navigationHandler = new NavigationHandler(navController);

        NavigationView navigationView = findViewById(R.id.nav_view);
        drawerHandler.setupDrawer(navigationView);
    }

    /**
     * Called when a character is clicked in the list, triggering navigation to the character detail screen.
     *
     * @param character The selected character.
     * @param view      The view associated with the click event.
     */
    public void characterClicked(Character character, View view) {
        navigationHandler.navigateToCharacterDetails(character, view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuHandler.onCreateOptionsMenu(menu, getMenuInflater());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return menuHandler.onOptionsItemSelected(item,
                menuHandler::showAboutDialog,
                drawerHandler::toggleDrawer) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp();
    }
}