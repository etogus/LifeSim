package com.mamedovga.lifesim;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mamedovga.lifesim.databinding.FragmentShopBinding;
import com.mamedovga.lifesim.models.AbstractAsset;
import com.mamedovga.lifesim.models.Book;
import com.mamedovga.lifesim.models.Car;
import com.mamedovga.lifesim.models.House;
import com.mamedovga.lifesim.models.Sport;

import java.util.ArrayList;

public class ShopFragment extends Fragment implements ShopAdapter.ItemClickListener {

    private FragmentShopBinding binding;
    //public static ArrayList<AbstractAsset> list = new ArrayList<>();
    public static ShopAdapter shopAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ShopFragment() {}

    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
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
        binding = FragmentShopBinding.inflate(inflater, container, false);
        //buildList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        binding.recyclerViewShop.setLayoutManager(linearLayoutManager);
        shopAdapter = new ShopAdapter(GameActivity.shopList, this);
        binding.recyclerViewShop.setAdapter(shopAdapter);

        binding.floatingActionButtonCloseShop.setOnClickListener(new View.OnClickListener() {
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
    public void onItemClick(AbstractAsset abstractAsset) {
        if(abstractAsset instanceof Book) {
            Log.e("onItemClick", "class: " + abstractAsset.getClass().getSimpleName());
            ShopDialogFragment dialog = ShopDialogFragment.newInstanceBook(abstractAsset.getName(), abstractAsset.getImage(),
                    abstractAsset.getPrice(), GameActivity.shopList.indexOf(abstractAsset), ((Book) abstractAsset).getType(), ((Book) abstractAsset).getPages(), abstractAsset.getClass().getSimpleName());
            dialog.setTargetFragment(ShopFragment.this, 1);
            dialog.show(getActivity().getSupportFragmentManager(), "ShopDialog");
        } else if(abstractAsset instanceof Car) {
            Log.e("onItemClick", "class: " + abstractAsset.getClass());
            ShopDialogFragment dialog = ShopDialogFragment.newInstanceCar(abstractAsset.getName(), abstractAsset.getImage(),
                    abstractAsset.getPrice(), GameActivity.shopList.indexOf(abstractAsset), ((Car) abstractAsset).getType(), ((Car) abstractAsset).getCondition(), abstractAsset.getClass().getSimpleName());
            dialog.setTargetFragment(ShopFragment.this, 1);
            dialog.show(getActivity().getSupportFragmentManager(), "ShopDialog");
        } else if(abstractAsset instanceof House) {
            Log.e("onItemClick", "class: " + abstractAsset.getClass());
            ShopDialogFragment dialog = ShopDialogFragment.newInstanceHouse(abstractAsset.getName(), abstractAsset.getImage(),
                    abstractAsset.getPrice(), GameActivity.shopList.indexOf(abstractAsset), ((House) abstractAsset).getType(), ((House) abstractAsset).getCondition(), ((House) abstractAsset).getRooms(), abstractAsset.getClass().getSimpleName());
            dialog.setTargetFragment(ShopFragment.this, 1);
            dialog.show(getActivity().getSupportFragmentManager(), "ShopDialog");
        } else if(abstractAsset instanceof Sport) {
            Log.e("onItemClick", "class: " + abstractAsset.getClass());
            ShopDialogFragment dialog = ShopDialogFragment.newInstanceSport(abstractAsset.getName(), abstractAsset.getImage(),
                    abstractAsset.getPrice(), GameActivity.shopList.indexOf(abstractAsset), ((Sport) abstractAsset).getType(), abstractAsset.getClass().getSimpleName());
            dialog.setTargetFragment(ShopFragment.this, 1);
            dialog.show(getActivity().getSupportFragmentManager(), "ShopDialog");
        }
    }
}