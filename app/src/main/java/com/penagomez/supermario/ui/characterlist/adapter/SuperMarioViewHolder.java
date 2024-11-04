package com.penagomez.supermario.ui.characterlist.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.penagomez.supermario.data.dto.Character;
import com.penagomez.supermario.databinding.CharacterCardviewBinding;
import com.squareup.picasso.Picasso;

public class SuperMarioViewHolder extends RecyclerView.ViewHolder {
    private final CharacterCardviewBinding binding;

    public SuperMarioViewHolder(CharacterCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Character superMario) {
        Picasso.get()
                .load(superMario.getImage())
                .into(binding.image);
        binding.name.setText(superMario.getName());
        binding.executePendingBindings();
    }

}
