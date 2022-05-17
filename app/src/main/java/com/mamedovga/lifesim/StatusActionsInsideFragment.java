package com.mamedovga.lifesim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mamedovga.lifesim.databinding.FragmentStatusActionsInsideBinding;
import com.mamedovga.lifesim.models.StatusAction;


public class StatusActionsInsideFragment extends Fragment implements StatusActionsAdapter.ItemClickListener {

    private FragmentStatusActionsInsideBinding binding;
    public static StatusActionsAdapter statusActionsInsideAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StatusActionsInsideFragment() { }

    public static StatusActionsInsideFragment newInstance(String param1, String param2) {
        StatusActionsInsideFragment fragment = new StatusActionsInsideFragment();
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
        binding = FragmentStatusActionsInsideBinding.inflate(inflater, container, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        binding.recyclerViewStatusActionsInside.setLayoutManager(linearLayoutManager);
        statusActionsInsideAdapter = new StatusActionsAdapter(GameActivity.statusActionsInside, this);
        binding.recyclerViewStatusActionsInside.setAdapter(statusActionsInsideAdapter);

        binding.floatingActionButtonCloseStatusActionsInside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view1 = getActivity().findViewById(R.id.bottomContainer);
                view1.setVisibility(View.VISIBLE);
                getActivity().onBackPressed();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onItemClick(StatusAction statusAction) {
        if(statusAction.getLabel().equals("classmates")) {
            StatusActionsInsidePeopleFragment statusActionsInsidePeopleFragment = new StatusActionsInsidePeopleFragment();
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.hide(requireActivity().getSupportFragmentManager().findFragmentByTag("statusActionsInsideFragment"));
            transaction.add(R.id.topAndMiddleContainer, statusActionsInsidePeopleFragment, "statusActionsInsidePeopleFragment");
            transaction.addToBackStack(null);
            transaction.commit();
            View view = getActivity().findViewById(R.id.bottomContainer);
            view.setVisibility(View.GONE);
        } else if(statusAction.getLabel().equals("study")) {
            ActionDialogFragment dialog = ActionDialogFragment.newInstance(statusAction.getImage(), 20, statusAction.getLabel(), statusAction.getName());
            dialog.setTargetFragment(StatusActionsInsideFragment.this, 1);
            dialog.show(getActivity().getSupportFragmentManager(), "StatusActionsInsideFragmentDialog");
        }

    }
}