package com.penagomez.supermario.ui.characterdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.penagomez.supermario.R;
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

        if (getArguments() != null) {
            int image = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String abilities = getArguments().getString("abilities");

            binding.characterImage.setImageResource(image);
            binding.characterName.setText(name);
            binding.characterDescription.setText(description);
            binding.characterAbilities.setText(abilities);

            // Muestra el Toast con el nombre del personaje
            String message = getString(R.string.detail_welcome_message) + " " + name;
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.character_detail);
        }
    }

}
