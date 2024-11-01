package com.penagomez.supermario;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.penagomez.supermario.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CharacterRepository repository;

    public MainActivity() {
        repository = new InMemoryCharacterRepository();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.superMarioRecyclerview.setLayoutManager(new LinearLayoutManager(this));


        binding.superMarioRecyclerview.setAdapter(new SuperMarioRecyclerViewAdapter(repository.findAll(), this));
    }

    public void characterClicked(SuperMarioData character, View view) {
        Bundle bundle = new Bundle();

        bundle.putInt("image", character.getImage());
        bundle.putString("name", character.getName());
        bundle.putString("description", character.getDescription());
    }
}