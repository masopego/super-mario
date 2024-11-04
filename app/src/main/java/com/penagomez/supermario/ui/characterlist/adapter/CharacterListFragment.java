package com.penagomez.supermario.ui.characterlist.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.penagomez.supermario.R;
import com.penagomez.supermario.data.dto.Character;
import com.penagomez.supermario.data.repository.CharacterRepository;
import com.penagomez.supermario.data.repository.InMemoryCharacterRepository;
import com.penagomez.supermario.databinding.CharacterListFragmentBinding;

import java.util.List;

public class CharacterListFragment extends Fragment {

    private CharacterListFragmentBinding binding;
    private CharacterRepository repository;
    private SuperMarioRecyclerViewAdapter adapter;

    public CharacterListFragment() {
        repository = new InMemoryCharacterRepository();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = CharacterListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        System.out.println("Hola, paso por aquí");

        List<Character> characters = repository.findAll();
        System.out.println("CHARACTERS" + characters.size());
        // Inicializa la lista de personajes
        adapter = new SuperMarioRecyclerViewAdapter(characters, getActivity());
        binding.superMarioRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.superMarioRecyclerview.setAdapter(adapter);
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
