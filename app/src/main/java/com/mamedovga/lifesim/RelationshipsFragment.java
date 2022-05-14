package com.mamedovga.lifesim;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mamedovga.lifesim.databinding.FragmentRelationshipsBinding;
import com.mamedovga.lifesim.databinding.FragmentStatusBinding;
import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.models.NonPlayableCharacter;
import com.mamedovga.lifesim.utils.PersonUtils;

import java.util.ArrayList;

public class RelationshipsFragment extends Fragment implements RelationshipsRecyclerViewAdapter.ItemClickListener {

    private FragmentRelationshipsBinding binding;
    private ArrayList<NonPlayableCharacter> list = new ArrayList<>();
    private MainCharacterViewModel mainCharacterViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRelationshipsBinding.inflate(inflater, container, false);
        buildList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        binding.recyclerViewFamily.setLayoutManager(linearLayoutManager);
        RelationshipsRecyclerViewAdapter recyclerViewAdapter = new RelationshipsRecyclerViewAdapter(list, this);
        binding.recyclerViewFamily.setAdapter(recyclerViewAdapter);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainCharacterViewModel = new ViewModelProvider(requireActivity()).get(MainCharacterViewModel.class);
    }

    private void buildList() {
        NonPlayableCharacter father = new NonPlayableCharacter(PersonUtils.getRandomFirstName("male", "Россия"),
                mainCharacterViewModel.getLastName().getValue(), "male", "country", 28, 90, "Папа");
        NonPlayableCharacter mother = new NonPlayableCharacter(PersonUtils.getRandomFirstName("female", "Россия"),
                mainCharacterViewModel.getLastName().getValue() + "а", "female", "country", 24, 80, "Мама");
        list.add(father);
        list.add(mother);
    }

    @Override
    public void onItemClick(NonPlayableCharacter nonPlayableCharacter) {
//        Fragment fragment = DetailFragment.newInstance(nonPlayableCharacter.getFullName());
//
//        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
//        transaction.hide(requireActivity().getSupportFragmentManager().findFragmentByTag("relationshipsFragment"));
//        transaction.add(R.id.topAndMiddleContainer, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
        RelationshipDialogFragment dialog = RelationshipDialogFragment.newInstance(nonPlayableCharacter.getAvatar(), nonPlayableCharacter.getStatusToPlayer(), nonPlayableCharacter.getAffinity(), nonPlayableCharacter.getName());
        Log.e("onItemClick", "nonPlayableCharacter.getStatusToPlayer() = " + nonPlayableCharacter.getStatusToPlayer());
        dialog.setTargetFragment(RelationshipsFragment.this, 1);
        dialog.show(getActivity().getSupportFragmentManager(), "MyCustomDialog");
    }
}