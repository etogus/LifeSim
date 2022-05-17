package com.mamedovga.lifesim;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mamedovga.lifesim.databinding.FragmentStatusPeopleDialogBinding;

public class StatusPeopleDialogFragment extends DialogFragment {

    private FragmentStatusPeopleDialogBinding binding;

    private static final String ARG_PARAM1 = "avatar";
    private static final String ARG_PARAM2 = "statusToPlayer";
    private static final String ARG_PARAM3 = "affinityToPlayer";
    private static final String ARG_PARAM4 = "name";

    private int mParam1;
    private String mParam2;
    private int mParam3;
    private String mParam4;

    public StatusPeopleDialogFragment() { }

    public static StatusPeopleDialogFragment newInstance(int param1, String param2, int param3, String param4) {
        StatusPeopleDialogFragment fragment = new StatusPeopleDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStatusPeopleDialogBinding.inflate(inflater, container, false);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        binding.charAvatar.setImageResource(mParam1);
        binding.charStatusToPlayer.setText(mParam2);
        binding.relationshipBar.setProgressPercentage(mParam3, false);

        binding.actionClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        binding.actionChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatFragment fragment = ChatFragment.newInstance(mParam1, mParam4, mParam2);
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.hide(requireActivity().getSupportFragmentManager().findFragmentByTag("statusActionsInsidePeopleFragment"));
                transaction.add(R.id.topAndMiddleContainer, fragment, "chatFragment");
                transaction.addToBackStack(null);
                transaction.commit();
                View view = getActivity().findViewById(R.id.bottomContainer);
                view.setVisibility(View.GONE);
                getDialog().dismiss();
            }
        });

        return binding.getRoot();
    }
}