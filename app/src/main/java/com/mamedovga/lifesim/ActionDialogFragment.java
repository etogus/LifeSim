package com.mamedovga.lifesim;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mamedovga.lifesim.databinding.FragmentActionDialogBinding;
import com.mamedovga.lifesim.databinding.FragmentActionsBinding;
import com.mamedovga.lifesim.models.MainCharacterViewModel;

public class ActionDialogFragment extends DialogFragment {

    private FragmentActionDialogBinding binding;
    private MainCharacterViewModel mainCharacterViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "image";
    private static final String ARG_PARAM2 = "energy";
    private static final String ARG_PARAM3 = "label";

    // TODO: Rename and change types of parameters
    private int dialogImage;
    private int dialogEnergy;
    private String dialogLabel;

    public ActionDialogFragment() {
        // Required empty public constructor
    }

    public static ActionDialogFragment newInstance(int param1, int param2, String param3) {
        ActionDialogFragment fragment = new ActionDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dialogImage = getArguments().getInt(ARG_PARAM1);
            dialogEnergy = getArguments().getInt(ARG_PARAM2);
            dialogLabel = getArguments().getString(ARG_PARAM3);
        }
        mainCharacterViewModel = new ViewModelProvider(requireActivity()).get(MainCharacterViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentActionDialogBinding.inflate(inflater, container, false);
        binding.actionImage.setImageResource(dialogImage);
        binding.energyCost.setText(String.valueOf(dialogEnergy));

        binding.actionClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });

        binding.actionDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (dialogLabel) {
                    case "gym":
                        if(mainCharacterViewModel.getEnergy().getValue() >= dialogEnergy) {
                            mainCharacterViewModel.setHealth(mainCharacterViewModel.getHealth().getValue() + 10);
                            mainCharacterViewModel.setEnergy(mainCharacterViewModel.getEnergy().getValue() - dialogEnergy);
                        } else {
                            Toast.makeText(requireContext(), "Недостаточно энергии", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "book":
                    case "game":
                    case "movie":
                        if(mainCharacterViewModel.getEnergy().getValue() >= dialogEnergy) {
                            mainCharacterViewModel.setMood(mainCharacterViewModel.getMood().getValue() + 5);
                            mainCharacterViewModel.setEnergy(mainCharacterViewModel.getEnergy().getValue() - dialogEnergy);
                        } else {
                            Toast.makeText(requireContext(), "Недостаточно энергии", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "doctor":
                        if(mainCharacterViewModel.getEnergy().getValue() >= dialogEnergy) {
                            mainCharacterViewModel.setHealth(mainCharacterViewModel.getHealth().getValue() + 5);
                            mainCharacterViewModel.setEnergy(mainCharacterViewModel.getEnergy().getValue() - dialogEnergy);
                        } else {
                            Toast.makeText(requireContext(), "Недостаточно энергии", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                getDialog().dismiss();
            }
        });

        return binding.getRoot();
    }
}