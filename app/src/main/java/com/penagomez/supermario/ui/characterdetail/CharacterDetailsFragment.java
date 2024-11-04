package com.penagomez.supermario.ui.characterdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.penagomez.supermario.R;
import com.penagomez.supermario.data.dto.Character;
import com.penagomez.supermario.data.repository.CharacterRepository;
import com.penagomez.supermario.data.repository.InMemoryCharacterRepository;
import com.penagomez.supermario.databinding.CharacterDetailsFragmentBinding;

public class CharacterDetailsFragment extends Fragment {
    private CharacterDetailsFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = CharacterDetailsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CharacterRepository repository = new InMemoryCharacterRepository();
        Character data = repository.findAll().get(0);

        binding.characterImage.setImageResource(data.getImage());
        binding.characterName.setText(data.getName());
        binding.characterDescription.setText(data.getDescription());
        binding.characterAbilities.setText(data.getAbilities());
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.character_detail);
        }
    }

}
