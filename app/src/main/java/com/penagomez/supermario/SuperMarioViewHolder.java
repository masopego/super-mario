package com.penagomez.supermario;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import com.penagomez.supermario.databinding.SuperMarioCardviewBinding;

public class SuperMarioViewHolder extends RecyclerView.ViewHolder  {
    private final SuperMarioCardviewBinding binding;

    public SuperMarioViewHolder(SuperMarioCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (SuperMarioData superMario){
        Picasso.get()
                .load(superMario.getImage())
                .into(binding.image);
        binding.name.setText(superMario.getName());
        binding.description.setText(superMario.getDescription());
        binding.executePendingBindings();
    }

}
