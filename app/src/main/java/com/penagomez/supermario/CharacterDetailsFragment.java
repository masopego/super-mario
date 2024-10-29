package com.penagomez.supermario;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.penagomez.supermario.databinding.FragmentCharacterDetailsBinding;

public class CharacterDetailsFragment extends Fragment {
    private FragmentCharacterDetailsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false);

        String name = String.valueOf(R.string.mario);
        String description = String.valueOf(R.string.kingdom_hero);
        String abilities = String.valueOf(R.string.jumping);
        int imageResourceId = R.drawable.mario;




        binding.characterImage.setImageResource(imageResourceId);
        binding.characterName.setText(name);
        binding.characterDescription.setText(description);
        binding.characterAbilities.setText(abilities);


        return binding.getRoot();


    }


}
