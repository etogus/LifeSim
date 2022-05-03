package com.mamedovga.lifesim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.mamedovga.lifesim.databinding.FragmentDialogEventBinding;
import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.utils.ProgressBarUtils;


public class EventDialogFragment extends DialogFragment {

    private FragmentDialogEventBinding binding;
    private MainCharacterViewModel mainCharacterViewModel;

    private static final String ARG_PARAM1 = "eventName";
    private static final String ARG_PARAM2 = "eventImage";
    private static final String ARG_PARAM3 = "eventDescription";
    private static final String ARG_PARAM4 = "positiveAction";
    private static final String ARG_PARAM5 = "negativeAction";
    private static final String ARG_PARAM6 = "thirdAction";
    private static final String ARG_PARAM7 = "label";

    private String eventName;
    private int eventImage;
    private String eventDescription;
    private String positiveAction;
    private String negativeAction;
    private String thirdAction;
    private String label;

    public EventDialogFragment() { }


    public static EventDialogFragment newInstance(String param1, int param2, String param3, String param4, String param5, String param6, String param7) {
        EventDialogFragment fragment = new EventDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putString(ARG_PARAM6, param6);
        args.putString(ARG_PARAM7, param7);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            eventName = getArguments().getString(ARG_PARAM1);
            eventImage = getArguments().getInt(ARG_PARAM2);
            eventDescription = getArguments().getString(ARG_PARAM3);
            positiveAction = getArguments().getString(ARG_PARAM4);
            negativeAction = getArguments().getString(ARG_PARAM5);
            thirdAction = getArguments().getString(ARG_PARAM6);
            label = getArguments().getString(ARG_PARAM7);
        }
        mainCharacterViewModel = new ViewModelProvider(requireActivity()).get(MainCharacterViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogEventBinding.inflate(inflater, container, false);
        binding.eventName.setText(eventName);
        binding.eventImage.setImageResource(eventImage);
        binding.eventDescription.setText(eventDescription);
        binding.positiveAction.setText(positiveAction);
        binding.negativeAction.setText(negativeAction);

        if(!thirdAction.equals("")) {
            binding.thirdAction.setText(thirdAction);
        } else {
            binding.thirdAction.setVisibility(View.GONE);
        }

        binding.positiveAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (label) {
                    case "bornMomCalls":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, 10, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                    case "childMomAsksDrink":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, 4, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        ProgressBarUtils.updateHealthBar(mainCharacterViewModel, 8, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.healthBar));
                        break;
                    case "childMomTakesToDoc":
                        ProgressBarUtils.updateHealthBar(mainCharacterViewModel, 10, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.healthBar));
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, -5, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                    case "childGirlTakesToy":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, 5, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                    case "primarySchoolKidsAskToMovie":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, 8, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                    case "primarySchoolParentsAskToVacation":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, 6, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                }
                getDialog().dismiss();
            }
        });

        binding.negativeAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (label) {
                    case "bornMomCalls":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, -10, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                    case "childMomAsksDrink":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, 5, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        ProgressBarUtils.updateHealthBar(mainCharacterViewModel, -8, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.healthBar));
                        break;
                    case "childMomTakesToDoc":
                        ProgressBarUtils.updateHealthBar(mainCharacterViewModel, -10, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.healthBar));
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, -5, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                    case "childGirlTakesToy":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, -8, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                    case "primarySchoolKidsAskToMovie":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, -6, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                    case "primarySchoolParentsAskToVacation":
                        ProgressBarUtils.updateMoodBar(mainCharacterViewModel, -15, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                        break;
                }
                getDialog().dismiss();
            }
        });

        if(binding.thirdAction.getVisibility() == View.VISIBLE) {
            binding.thirdAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (label) {
                        case "bornMomCalls":
                            ProgressBarUtils.updateMoodBar(mainCharacterViewModel, 5, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                            break;
                        case "childMomAsksDrink":
                            ProgressBarUtils.updateMoodBar(mainCharacterViewModel, 4, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                            ProgressBarUtils.updateHealthBar(mainCharacterViewModel, 4, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.healthBar));
                            break;
                        case "childMomTakesToDoc":
                            ProgressBarUtils.updateHealthBar(mainCharacterViewModel, -3, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.healthBar));
                            ProgressBarUtils.updateMoodBar(mainCharacterViewModel, -5, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                            break;
                        case "childGirlTakesToy":
                            ProgressBarUtils.updateMoodBar(mainCharacterViewModel, -2, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                            break;
                        case "primarySchoolParentsAskToVacation":
                            ProgressBarUtils.updateMoodBar(mainCharacterViewModel, -5, getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.moodBar));
                            break;
                    }
                    getDialog().dismiss();
                }
            });
        }

        return binding.getRoot();
    }
}