package com.penagomez.supermario.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.penagomez.supermario.R;
import com.penagomez.supermario.data.dto.Character;
import com.penagomez.supermario.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavController navController;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Configura el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController);


        // Configura el DrawerLayout y NavigationView
        drawerLayout = binding.drawerLayout;
        NavigationView navigationView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

    }


    public void characterClicked(Character character, View view) {
        Bundle bundle = new Bundle();

        bundle.putInt("image", character.getImage());
        bundle.putString("name", character.getName());
        bundle.putString("description", character.getDescription());
        bundle.putString("abilities", character.getAbilities());

        // Navegar al CharacterDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.characterDetailsFragment, bundle);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about_us) {
            showAboutDialog();
            return true;
        }
        if (item.getItemId() == R.id.action_menu) {

            if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                drawerLayout.closeDrawer(GravityCompat.END);
            } else {
                drawerLayout.openDrawer(GravityCompat.END);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            return NavigationUI.navigateUp(navController, binding.drawerLayout);
        }
        return super.onSupportNavigateUp();
    }

    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher) // Usa el icono de la app
                .setTitle(getString(R.string.about_us_title))
                .setMessage(getString(R.string.about_us_message))
                .setPositiveButton(getString(R.string.about_us_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }


    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            navController.navigate(R.id.characterListFragment);
        } else if (itemId == R.id.nav_settings) {
            navController.navigate(R.id.preferencesFragment);
        } else {
            throw new IllegalStateException("Unexpected value: " + itemId);
        }
        drawerLayout.closeDrawer(GravityCompat.END);
        return true;
    }

}