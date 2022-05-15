package com.mamedovga.lifesim;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

import com.mamedovga.lifesim.databinding.FragmentAssetDialogBinding;
import com.mamedovga.lifesim.models.AbstractAsset;
import com.mamedovga.lifesim.models.Book;
import com.mamedovga.lifesim.models.Car;
import com.mamedovga.lifesim.models.House;
import com.mamedovga.lifesim.models.Sport;

public class AssetDialogFragment extends DialogFragment {

    private static final String ARG_PARAM1 = "name";
    private static final String ARG_PARAM2 = "image";
    private static final String ARG_PARAM3 = "index";

    private FragmentAssetDialogBinding binding;

    private String mParam1;
    private int mParam2;
    private int mParam3;

    public AssetDialogFragment() { }

    public static AssetDialogFragment newInstance(String param1, int param2, int param3) {
        AssetDialogFragment fragment = new AssetDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAssetDialogBinding.inflate(inflater, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        binding.assetItemName.setText(mParam1);
        binding.assetItemImage.setImageResource(mParam2);

        AbstractAsset abstractAsset = GameActivity.assetList.get(mParam3);
        if(abstractAsset instanceof Book) {
            binding.actionUseAsset.setText("Прочитать");
        } else if(abstractAsset instanceof Car) {
            binding.actionUseAsset.setText("Прокатиться");
        } else if(abstractAsset instanceof House) {
            binding.actionUseAsset.setVisibility(View.GONE);
        } else if(abstractAsset instanceof Sport) { }

        binding.actionUseAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbstractAsset abstractAsset = GameActivity.assetList.get(mParam3);
                if(abstractAsset instanceof Book) {
                    GameActivity.assetList.remove(mParam3);
                    AssetsFragment.assetsAdapter.notifyDataSetChanged();
                    getDialog().dismiss();
                } else if(abstractAsset instanceof Car) {
                    getDialog().dismiss();
                } else if(abstractAsset instanceof House) {
                    getDialog().dismiss();
                } else if(abstractAsset instanceof Sport) {
                    getDialog().dismiss();
                }
            }
        });

        binding.actionCloseAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return binding.getRoot();
    }
}