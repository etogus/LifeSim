package com.mamedovga.lifesim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mamedovga.lifesim.databinding.FragmentRelationshipsBinding;
import com.mamedovga.lifesim.databinding.FragmentStatusBinding;
import com.mamedovga.lifesim.models.NonPlayableCharacter;

import java.util.ArrayList;

public class RelationshipsFragment extends Fragment implements RelationshipsRecyclerViewAdapter.ItemClickListener {

    private FragmentRelationshipsBinding binding;
    private ArrayList<NonPlayableCharacter> list = new ArrayList<>();

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

    private void buildList() {
        list.add(new NonPlayableCharacter("Name", "LastName", "male", "country", 28, 100, "unknown"));
        list.add(new NonPlayableCharacter("Name2", "LastName2", "female", "country", 24, 100, "unknown"));
    }

    @Override
    public void onItemClick(NonPlayableCharacter nonPlayableCharacter) {
        Fragment fragment = DetailFragment.newInstance(nonPlayableCharacter.getFullName());
        Log.e("onItemClick", "nonPlayableCharacter.getFullName() = " + nonPlayableCharacter.getFullName());
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        //transaction.replace(R.id.topAndMiddleContainer, fragment, "detail");
        transaction.hide(requireActivity().getSupportFragmentManager().findFragmentByTag("relationshipsFragment"));
        transaction.add(R.id.topAndMiddleContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}