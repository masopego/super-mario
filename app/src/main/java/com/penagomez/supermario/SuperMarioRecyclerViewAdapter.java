package com.penagomez.supermario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.penagomez.supermario.databinding.SuperMarioCardviewBinding;

import java.util.List;

public class SuperMarioRecyclerViewAdapter extends RecyclerView.Adapter<SuperMarioViewHolder> {
    private final List<SuperMarioData> characters;
    private final Context context;

    public SuperMarioRecyclerViewAdapter(List<SuperMarioData> characters, Context context) {
        this.characters = characters;
        this.context = context;
    }

    @NonNull
    @Override
    public SuperMarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SuperMarioCardviewBinding binding = SuperMarioCardviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SuperMarioViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperMarioViewHolder holder, int position) {
        SuperMarioData currentCharacter = this.characters.get(position);
        holder.bind(currentCharacter);

        holder.itemView.setOnClickListener(view -> itemClicked(currentCharacter, view));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    private void itemClicked(SuperMarioData currentCharacter, View view) {
        ((MainActivity) context).characterClicked(currentCharacter, view);
    }
}
