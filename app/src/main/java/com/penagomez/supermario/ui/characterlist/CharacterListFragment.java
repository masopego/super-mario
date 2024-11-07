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

/**
 * CharacterListFragment displays a list of Super Mario characters in a RecyclerView.
 * It initializes data from a CharacterRepository and sets up the adapter to manage the
 * list presentation. A Snackbar with a welcome message is shown upon loading the view.
 */
public class CharacterListFragment extends Fragment {

    private CharacterListFragmentBinding binding;
    private CharacterRepository repository;
    private SuperMarioRecyclerViewAdapter adapter;

    /**
     * Inflates the fragment's view and initializes the CharacterRepository.
     *
     * @param inflater           The LayoutInflater object used to inflate views in the fragment.
     * @param container          The parent view the fragment's UI is attached to, if applicable.
     * @param savedInstanceState Bundle containing previous instance state, if available.
     * @return The root view of the fragment, with binding applied.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = CharacterListFragmentBinding.inflate(inflater, container, false);

        // Initialize repository for fetching character data
        if (getContext() != null) {
            repository = new InMemoryCharacterRepository(getContext());
        }

        return binding.getRoot();
    }

    /**
     * Called after the view is created. Initializes the RecyclerView to display
     * the list of characters and shows a welcome message using a Snackbar.
     *
     * @param view               The fragment's view.
     * @param savedInstanceState Bundle with saved state information.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Fetch the list of characters from the repository
        List<Character> characters = repository.findAll();

        // Initialize the RecyclerView with character data and layout manager
        adapter = new SuperMarioRecyclerViewAdapter(characters, getActivity());
        binding.superMarioRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.superMarioRecyclerview.setAdapter(adapter);

        // Show a welcome message with Snackbar
        Snackbar.make(binding.getRoot(), getString(R.string.list_welcome_message), Snackbar.LENGTH_LONG).show();
    }

    /**
     * Sets the action bar title to "Character List" when the fragment becomes visible.
     * Ensures the activity's action bar is updated appropriately.
     */
    @Override
    public void onStart() {
        super.onStart();

        // Update the action bar title when fragment is visible
        if (getActivity() != null) {
            // Show the action bar when this fragment starts
            ((AppCompatActivity) getActivity()).getSupportActionBar().show();
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.character_list);
        }
    }
}