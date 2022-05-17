package com.mamedovga.lifesim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mamedovga.lifesim.databinding.FragmentStatusActionsInsidePeopleBinding;
import com.mamedovga.lifesim.models.NonPlayableCharacter;

public class StatusActionsInsidePeopleFragment extends Fragment implements RelationshipsRecyclerViewAdapter.ItemClickListener {

    private FragmentStatusActionsInsidePeopleBinding binding;
    public static RelationshipsRecyclerViewAdapter statusActionsInsidePeopleAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public StatusActionsInsidePeopleFragment() { }

    public static StatusActionsInsidePeopleFragment newInstance(String param1, String param2) {
        StatusActionsInsidePeopleFragment fragment = new StatusActionsInsidePeopleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStatusActionsInsidePeopleBinding.inflate(inflater, container, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        binding.recyclerViewStatusActionsInsidePeople.setLayoutManager(linearLayoutManager);
        statusActionsInsidePeopleAdapter = new RelationshipsRecyclerViewAdapter(GameActivity.statusActionsInsidePeople, this);
        binding.recyclerViewStatusActionsInsidePeople.setAdapter(statusActionsInsidePeopleAdapter);

        binding.floatingActionButtonCloseStatusActionsInsidePeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onItemClick(NonPlayableCharacter nonPlayableCharacter) {
        StatusPeopleDialogFragment dialog = StatusPeopleDialogFragment.newInstance(nonPlayableCharacter.getAvatar(), nonPlayableCharacter.getStatusToPlayer(), nonPlayableCharacter.getAffinity(), nonPlayableCharacter.getName());
        dialog.setTargetFragment(StatusActionsInsidePeopleFragment.this, 1);
        dialog.show(getActivity().getSupportFragmentManager(), "statusActionsInsidePeopleFragmentDialog");
    }
}