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

/**
 * Fragment class for displaying the details of a selected character.
 * Shows an image, name, description, and abilities of the character.
 */
public class CharacterDetailsFragment extends Fragment {
    private CharacterDetailsFragmentBinding binding;

    /**
     * Inflates the layout for this fragment using view binding.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate views in the fragment.
     * @param container          The parent view that this fragment's UI will be attached to.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     * @return The root view of the inflated layout.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = CharacterDetailsFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Called immediately after onCreateView. Retrieves character details passed as arguments
     * and binds them to the layout views, including setting the image, name, description, and abilities.
     * Displays a welcome Toast message that includes the character's name.
     *
     * @param view               The View returned by onCreateView.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            // Retrieve character details from the arguments bundle
            int image = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String abilities = getArguments().getString("abilities");

            // Bind the character details to the UI elements
            binding.characterImage.setImageResource(image);
            binding.characterName.setText(name);
            binding.characterDescription.setText(description);
            binding.characterAbilities.setText(abilities);

            // Show a welcome Toast message with the character's name
            String message = getString(R.string.detail_welcome_message) + " " + name;
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Sets the title of the ActionBar to "Character Detail" when the fragment is visible.
     * Called after onViewCreated and is used to update the Activity's ActionBar title.
     */
    @Override
    public void onStart() {
        super.onStart();
        if (getActivity() != null) {
            // Show the action bar when this fragment starts
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.character_detail);
        }
    }
}
