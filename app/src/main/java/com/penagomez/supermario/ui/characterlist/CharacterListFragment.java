package com.penagomez.supermario.ui.characterlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.penagomez.supermario.R;
import com.penagomez.supermario.data.dto.Character;
import com.penagomez.supermario.data.repository.CharacterRepository;
import com.penagomez.supermario.data.repository.InMemoryCharacterRepository;
import com.penagomez.supermario.databinding.CharacterListFragmentBinding;
import com.penagomez.supermario.ui.characterlist.adapter.SuperMarioRecyclerViewAdapter;

import java.util.List;

public class CharacterListFragment extends Fragment {

    private CharacterListFragmentBinding binding;
    private CharacterRepository repository;
    private SuperMarioRecyclerViewAdapter adapter;
    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = CharacterListFragmentBinding.inflate(inflater, container, false);

        if (getContext() != null) {
            repository = new InMemoryCharacterRepository(getContext());  // Pasa el contexto correctamente
        }

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Character> characters = repository.findAll();

        // Inicializa la lista de personajes
        adapter = new SuperMarioRecyclerViewAdapter(characters, getActivity());
        binding.superMarioRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.superMarioRecyclerview.setAdapter(adapter);

        // Muestra el Snackbar con el mensaje de bienvenida
        Snackbar.make(binding.getRoot(), getString(R.string.list_welcome_message), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("START");
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.character_list);
        }
    }


}