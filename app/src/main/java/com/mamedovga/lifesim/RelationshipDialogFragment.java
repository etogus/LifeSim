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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mamedovga.lifesim.databinding.FragmentNewGameInputBinding;
import com.mamedovga.lifesim.databinding.FragmentRelationshipDialogBinding;


public class RelationshipDialogFragment extends DialogFragment {

    private static final String TAG = "MyCustomDialog";
    private FragmentRelationshipDialogBinding binding;

    private static final String ARG_PARAM1 = "avatar";
    private static final String ARG_PARAM2 = "statusToPlayer";
    private static final String ARG_PARAM3 = "affinityToPlayer";
    private static final String ARG_PARAM4 = "name";

    private int mParam1;
    private String mParam2;
    private int mParam3;
    private String mParam4;

    public RelationshipDialogFragment() { }

    public static RelationshipDialogFragment newInstance(int param1, String param2, int param3, String param4) {
        RelationshipDialogFragment fragment = new RelationshipDialogFragment();
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
        binding = FragmentRelationshipDialogBinding.inflate(inflater, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        binding.charAvatar.setImageResource(mParam1);
        binding.charStatusToPlayer.setText(mParam2);
        binding.relationshipBar.setProgressPercentage(mParam3, false);
        Log.e("onCreateView", "mParam2 = " + mParam2);

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

                ChatFragment fragment = ChatFragment.newInstance(mParam1, mParam4, mParam2);
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