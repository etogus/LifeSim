package com.mamedovga.lifesim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mamedovga.lifesim.databinding.FragmentAssetsBinding;
import com.mamedovga.lifesim.models.AbstractAsset;

public class AssetsFragment extends Fragment implements AssetsAdapter.ItemClickListener {

    private FragmentAssetsBinding binding;
    //private ArrayList<AbstractAsset> list = new ArrayList<>();
    public static AssetsAdapter assetsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAssetsBinding.inflate(inflater, container, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        binding.recyclerViewAssets.setLayoutManager(linearLayoutManager);
        assetsAdapter = new AssetsAdapter(GameActivity.assetList, this);
        binding.recyclerViewAssets.setAdapter(assetsAdapter);

        binding.floatingActionButtonBuyAssets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopFragment shopFragment = new ShopFragment();
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.hide(requireActivity().getSupportFragmentManager().findFragmentByTag("assetsFragment"));
                transaction.add(R.id.topAndMiddleContainer, shopFragment, "shopFragment");
                transaction.addToBackStack(null);
                transaction.commit();
                View view = getActivity().findViewById(R.id.bottomContainer);
                view.setVisibility(View.GONE);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onItemClick(AbstractAsset abstractAsset) {
        AssetDialogFragment dialog = AssetDialogFragment.newInstance(abstractAsset.getName(), abstractAsset.getImage(), GameActivity.assetList.indexOf(abstractAsset));
        dialog.setTargetFragment(AssetsFragment.this, 1);
        dialog.show(getActivity().getSupportFragmentManager(), "AssetsDialog");
    }
}