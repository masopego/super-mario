package com.penagomez.supermario.ui.handler;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;

import com.penagomez.supermario.R;

/**
 * MenuHandler manages menu-related tasks for the MainActivity, including inflating the menu,
 * handling item selection, and displaying the "About" dialog.
 */
public class MenuHandler {

    private final Context context;

    /**
     * Constructor for MenuHandler.
     *
     * @param context The Context in which this handler is used, usually the MainActivity.
     */
    public MenuHandler(Context context) {
        this.context = context;
    }

    /**
     * Inflates the menu options using the specified inflater.
     *
     * @param menu     The menu to inflate.
     * @param inflater The MenuInflater to use for inflating the menu.
     */
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    /**
     * Handles the selection of menu items. Shows the "About" dialog or toggles the drawer as needed.
     *
     * @param item            The selected menu item.
     * @param showAboutDialog Runnable to show the "About" dialog.
     * @param toggleDrawer    Runnable to toggle the drawer visibility.
     * @return true if the event was handled; false otherwise.
     */
    public boolean onOptionsItemSelected(MenuItem item, Runnable showAboutDialog, Runnable toggleDrawer) {
        if (item.getItemId() == R.id.action_about_us) {
            showAboutDialog.run();
            return true;
        } else if (item.getItemId() == R.id.action_menu) {
            toggleDrawer.run();
            return true;
        }
        return false;
    }

    /**
     * Displays an "About" dialog with app information.
     */
    public void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.ic_launcher)
                .setTitle(context.getString(R.string.about_us_title))
                .setMessage(context.getString(R.string.about_us_message))
                .setPositiveButton(context.getString(R.string.about_us_button), (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }
}