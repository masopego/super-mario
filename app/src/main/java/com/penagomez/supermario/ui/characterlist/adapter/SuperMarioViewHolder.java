package com.penagomez.supermario.ui.characterlist.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.penagomez.supermario.data.dto.Character;
import com.penagomez.supermario.databinding.CharacterCardviewBinding;
import com.squareup.picasso.Picasso;

/**
 * SuperMarioViewHolder is a custom ViewHolder that manages the binding of character data
 * to the character card view in a RecyclerView. It leverages data binding for efficient
 * view updates and uses the Picasso library to load character images.
 */
public class SuperMarioViewHolder extends RecyclerView.ViewHolder {
    private final CharacterCardviewBinding binding;

    /**
     * Constructor initializes the ViewHolder with the given binding.
     *
     * @param binding The CharacterCardviewBinding that connects layout views to data.
     */
    public SuperMarioViewHolder(CharacterCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Binds the character data to the card view, setting the character's image and name.
     * Picasso is used to load the image asynchronously, and the binding is executed to
     * ensure immediate UI updates.
     *
     * @param superMario The Character object containing the data for the current card view.
     */
    public void bind(Character superMario) {
        Picasso.get()
                .load(superMario.getImage())
                .into(binding.image);
        binding.name.setText(superMario.getName());
        binding.executePendingBindings();
    }
}
