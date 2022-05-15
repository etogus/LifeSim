package com.mamedovga.lifesim;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.mamedovga.lifesim.databinding.FragmentShopDialogBinding;
import com.mamedovga.lifesim.models.Book;
import com.mamedovga.lifesim.models.Car;
import com.mamedovga.lifesim.models.House;
import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.models.Sport;

public class ShopDialogFragment extends DialogFragment {

    private FragmentShopDialogBinding binding;
    private MainCharacterViewModel mainCharacterViewModel;

    private static final String ARG_PARAM1 = "name";
    private static final String ARG_PARAM2 = "image";
    private static final String ARG_PARAM3 = "price";
    private static final String ARG_PARAM4 = "index";
    private static final String ARG_PARAM5 = "type";
    private static final String ARG_PARAM6 = "pages";
    private static final String ARG_PARAM7 = "condition";
    private static final String ARG_PARAM8 = "rooms";
    private static final String ARG_PARAM9 = "objectClass";

    private String mParam1;
    private int mParam2;
    private int mParam3;
    private int mParam4;
    private String mParam5;
    private int mParam6;
    private int mParam7;
    private int mParam8;
    private String mParam9;

    public ShopDialogFragment() { }

    public static ShopDialogFragment newInstanceBook(String param1, int param2, int param3, int param4, String param5, int param6, String param9) {
        ShopDialogFragment fragment = new ShopDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        args.putInt(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putInt(ARG_PARAM6, param6);
        args.putString(ARG_PARAM9, param9);
        fragment.setArguments(args);
        return fragment;
    }

    public static ShopDialogFragment newInstanceCar(String param1, int param2, int param3, int param4, String param5, int param7, String param9) {
        ShopDialogFragment fragment = new ShopDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        args.putInt(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putInt(ARG_PARAM7, param7);
        args.putString(ARG_PARAM9, param9);
        fragment.setArguments(args);
        return fragment;
    }

    public static ShopDialogFragment newInstanceHouse(String param1, int param2, int param3, int param4, String param5, int param7, int param8, String param9) {
        ShopDialogFragment fragment = new ShopDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        args.putInt(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putInt(ARG_PARAM7, param7);
        args.putInt(ARG_PARAM8, param8);
        args.putString(ARG_PARAM9, param9);
        fragment.setArguments(args);
        return fragment;
    }

    public static ShopDialogFragment newInstanceSport(String param1, int param2, int param3, int param4, String param5, String param9) {
        ShopDialogFragment fragment = new ShopDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        args.putInt(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putString(ARG_PARAM9, param9);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
            mParam4 = getArguments().getInt(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            mParam6 = getArguments().getInt(ARG_PARAM6);
            mParam7 = getArguments().getInt(ARG_PARAM7);
            mParam8 = getArguments().getInt(ARG_PARAM8);
            mParam9 = getArguments().getString(ARG_PARAM9);
        }
        mainCharacterViewModel = new ViewModelProvider(requireActivity()).get(MainCharacterViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShopDialogBinding.inflate(inflater, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        binding.shopDialogItemName.setText(mParam1);
        binding.shopDialogItemAvatar.setImageResource(mParam2);
        binding.shopDialogItemPrice.setText(String.valueOf(mParam3));

        binding.actionCloseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        binding.actionBuyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mParam9) {
                    case "Book":
                        if(mainCharacterViewModel.getMoney().getValue() >= mParam3) {
                            mainCharacterViewModel.setMoney(mainCharacterViewModel.getMoney().getValue() - mParam3);
                            GameActivity.assetList.add(new Book(mParam1, mParam3, mParam2, mParam5, mParam6));
                            AssetsFragment.assetsAdapter.notifyDataSetChanged();
                            GameActivity.shopList.remove(mParam4);
                            ShopFragment.shopAdapter.notifyDataSetChanged();

                            SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
                            stringBuilder.append(mainCharacterViewModel.getActivityLogText().getValue());
                            stringBuilder.append("\n").append("Я приобрёл новую книгу.");
                            mainCharacterViewModel.setActivityLogText(stringBuilder);
                            TextView activityDisplay = getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.activityDisplay);
                            activityDisplay.setText(mainCharacterViewModel.getActivityLogText().getValue());
                            TextView playerMoney = getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.playerMoney);
                            playerMoney.setText(mainCharacterViewModel.getMoney().getValue().toString());

                            GameActivity.YearOutcome += mParam3;
                            TextView yearOutcome = getFragmentManager().findFragmentByTag("assetsFragment").getView().findViewById(R.id.yearOutcome);
                            yearOutcome.setText(String.valueOf(GameActivity.YearOutcome));

                            GameActivity.AllTimeOutcome += mParam3;
                            TextView allTimeOutcome = getFragmentManager().findFragmentByTag("assetsFragment").getView().findViewById(R.id.lifetimeOutcome);
                            allTimeOutcome.setText(String.valueOf(GameActivity.AllTimeOutcome));

                        } else {
                            Toast.makeText(requireContext(), "Недостаточно средств", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Car":
                        if(mainCharacterViewModel.getMoney().getValue() >= mParam3) {
                            mainCharacterViewModel.setMoney(mainCharacterViewModel.getMoney().getValue() - mParam3);
                            GameActivity.assetList.add(new Car(mParam1, mParam3, mParam2, mParam5, mParam7));
                            AssetsFragment.assetsAdapter.notifyDataSetChanged();
                            GameActivity.shopList.remove(mParam4);
                            ShopFragment.shopAdapter.notifyDataSetChanged();

                            SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
                            stringBuilder.append(mainCharacterViewModel.getActivityLogText().getValue());
                            stringBuilder.append("\n").append("Я приобрёл новый автомобиль.");
                            mainCharacterViewModel.setActivityLogText(stringBuilder);
                            TextView activityDisplay = getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.activityDisplay);
                            activityDisplay.setText(mainCharacterViewModel.getActivityLogText().getValue());
                            TextView playerMoney = getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.playerMoney);
                            playerMoney.setText(mainCharacterViewModel.getMoney().getValue().toString());

                            GameActivity.YearOutcome += mParam3;
                            TextView yearOutcome = getFragmentManager().findFragmentByTag("assetsFragment").getView().findViewById(R.id.yearOutcome);
                            yearOutcome.setText(String.valueOf(GameActivity.YearOutcome));

                            GameActivity.AllTimeOutcome += mParam3;
                            TextView allTimeOutcome = getFragmentManager().findFragmentByTag("assetsFragment").getView().findViewById(R.id.lifetimeOutcome);
                            allTimeOutcome.setText(String.valueOf(GameActivity.AllTimeOutcome));

                        }
                        else {
                            Toast.makeText(requireContext(), "Недостаточно средств", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "House":
                        if(mainCharacterViewModel.getMoney().getValue() >= mParam3) {
                            mainCharacterViewModel.setMoney(mainCharacterViewModel.getMoney().getValue() - mParam3);
                            GameActivity.assetList.add(new House(mParam1, mParam3, mParam2, mParam5, mParam8, mParam7));
                            AssetsFragment.assetsAdapter.notifyDataSetChanged();
                            GameActivity.shopList.remove(mParam4);
                            ShopFragment.shopAdapter.notifyDataSetChanged();

                            SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
                            stringBuilder.append(mainCharacterViewModel.getActivityLogText().getValue());
                            stringBuilder.append("\n").append("Я приобрёл новый дом.");
                            mainCharacterViewModel.setActivityLogText(stringBuilder);
                            TextView activityDisplay = getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.activityDisplay);
                            activityDisplay.setText(mainCharacterViewModel.getActivityLogText().getValue());
                            TextView playerMoney = getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.playerMoney);
                            playerMoney.setText(mainCharacterViewModel.getMoney().getValue().toString());

                            GameActivity.YearOutcome += mParam3;
                            TextView yearOutcome = getFragmentManager().findFragmentByTag("assetsFragment").getView().findViewById(R.id.yearOutcome);
                            yearOutcome.setText(String.valueOf(GameActivity.YearOutcome));

                            GameActivity.AllTimeOutcome += mParam3;
                            TextView allTimeOutcome = getFragmentManager().findFragmentByTag("assetsFragment").getView().findViewById(R.id.lifetimeOutcome);
                            allTimeOutcome.setText(String.valueOf(GameActivity.AllTimeOutcome));

                        } else {
                            Toast.makeText(requireContext(), "Недостаточно средств", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Sport":
                        if(mainCharacterViewModel.getMoney().getValue() >= mParam3) {
                            mainCharacterViewModel.setMoney(mainCharacterViewModel.getMoney().getValue() - mParam3);
                            GameActivity.assetList.add(new Sport(mParam1, mParam3, mParam2, mParam5));
                            AssetsFragment.assetsAdapter.notifyDataSetChanged();
                            GameActivity.shopList.remove(mParam4);
                            ShopFragment.shopAdapter.notifyDataSetChanged();

                            SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
                            stringBuilder.append(mainCharacterViewModel.getActivityLogText().getValue());
                            stringBuilder.append("\n").append("Я приобрёл новые гантели.");
                            mainCharacterViewModel.setActivityLogText(stringBuilder);
                            TextView activityDisplay = getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.activityDisplay);
                            activityDisplay.setText(mainCharacterViewModel.getActivityLogText().getValue());
                            TextView playerMoney = getFragmentManager().findFragmentByTag("statusFragment").getView().findViewById(R.id.playerMoney);
                            playerMoney.setText(mainCharacterViewModel.getMoney().getValue().toString());

                            GameActivity.YearOutcome += mParam3;
                            TextView yearOutcome = getFragmentManager().findFragmentByTag("assetsFragment").getView().findViewById(R.id.yearOutcome);
                            yearOutcome.setText(String.valueOf(GameActivity.YearOutcome));

                            GameActivity.AllTimeOutcome += mParam3;
                            TextView allTimeOutcome = getFragmentManager().findFragmentByTag("assetsFragment").getView().findViewById(R.id.lifetimeOutcome);
                            allTimeOutcome.setText(String.valueOf(GameActivity.AllTimeOutcome));

                        } else {
                            Toast.makeText(requireContext(), "Недостаточно средств", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                getDialog().dismiss();
            }
        });

        return binding.getRoot();
    }
}