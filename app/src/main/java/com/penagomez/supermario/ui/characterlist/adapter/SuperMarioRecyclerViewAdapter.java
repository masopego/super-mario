package com.penagomez.supermario.ui.characterlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.penagomez.supermario.data.dto.Character;
import com.penagomez.supermario.databinding.CharacterCardviewBinding;
import com.penagomez.supermario.ui.MainActivity;

import java.util.List;

/**
 * Adapter for displaying a list of Character items in a RecyclerView.
 * Uses SuperMarioViewHolder to bind each character's details to a card view layout.
 */
public class SuperMarioRecyclerViewAdapter extends RecyclerView.Adapter<SuperMarioViewHolder> {
    private final List<Character> characters;
    private final Context context;

    /**
     * Constructor to initialize the adapter with a list of characters and a context.
     *
     * @param characters The list of Character objects to display.
     * @param context    The Context in which the adapter is operating, usually an Activity.
     */
    public SuperMarioRecyclerViewAdapter(List<Character> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    /**
     * Called when RecyclerView needs a new ViewHolder for a character item.
     * Inflates the character card view layout and creates a new SuperMarioViewHolder instance.
     *
     * @param parent   The ViewGroup into which the new view will be added.
     * @param viewType The view type of the new View.
     * @return A new instance of SuperMarioViewHolder.
     */
    @NonNull
    @Override
    public SuperMarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterCardviewBinding binding = CharacterCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new SuperMarioViewHolder(binding);
    }

    /**
     * Binds data to the ViewHolder for a specific position. Sets up the character details
     * in the card view and defines an item click listener to handle user interaction.
     *
     * @param holder   The ViewHolder which should be updated with new data.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull SuperMarioViewHolder holder, int position) {
        // Get the current character and bind data to the ViewHolder
        Character currentCharacter = this.characters.get(position);
        holder.bind(currentCharacter);

        // Set click listener to trigger navigation or other actions
        holder.itemView.setOnClickListener(view -> itemClicked(currentCharacter, view));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The number of character items in the list.
     */
    @Override
    public int getItemCount() {
        return characters.size();
    }

    /**
     * Handles the click event for an individual character item, triggering a method in the
     * MainActivity to navigate to a character detail view with the selected character's data.
     *
     * @param currentCharacter The Character object that was clicked.
     * @param view             The View that was clicked.
     */
    private void itemClicked(Character currentCharacter, View view) {
        ((MainActivity) context).characterClicked(currentCharacter, view);
    }
}
