package com.mamedovga.lifesim;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mamedovga.lifesim.databinding.FragmentNewGameInputBinding;
import com.mamedovga.lifesim.databinding.FragmentRelationshipDialogBinding;


public class RelationshipDialogFragment extends DialogFragment {

    private static final String TAG = "MyCustomDialog";
    private FragmentRelationshipDialogBinding binding;

    private static final String ARG_PARAM1 = "param1";

    private int mParam1;

    public RelationshipDialogFragment() { }

    public static RelationshipDialogFragment newInstance(int param1) {
        RelationshipDialogFragment fragment = new RelationshipDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRelationshipDialogBinding.inflate(inflater, container, false);
        binding.charAvatar.setImageResource(mParam1);

        binding.actionClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });

        binding.actionChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: capturing input.");

                ChatFragment fragment = new ChatFragment();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.hide(requireActivity().getSupportFragmentManager().findFragmentByTag("relationshipsFragment"));
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