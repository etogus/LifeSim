package com.mamedovga.lifesim;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mamedovga.lifesim.databinding.FragmentNewGameAvatarBinding;
import com.mamedovga.lifesim.databinding.FragmentNewGameInputBinding;
import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.utils.ImageUtils;
import com.mamedovga.lifesim.utils.PersonUtils;

import java.util.ArrayList;
import java.util.List;

public class NewGameAvatarFragment extends Fragment {

    private FragmentNewGameAvatarBinding binding;
    private static int avatar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewGameAvatarBinding.inflate(inflater, container, false);
        List<SliderItem> sliderItems = new ArrayList<>();
        if(NewGameInputFragment.getGender().equals("male")) {
            sliderItems.add(new SliderItem(ImageUtils.decodeSampledBitmapFromResource(getResources(),
                    PersonUtils.maleAvatars[0], 100, 100)));
            sliderItems.add(new SliderItem(ImageUtils.decodeSampledBitmapFromResource(getResources(),
                    PersonUtils.maleAvatars[1], 100, 100)));
        } else {
            sliderItems.add(new SliderItem(ImageUtils.decodeSampledBitmapFromResource(getResources(),
                    PersonUtils.femaleAvatars[0], 100, 100)));
            sliderItems.add(new SliderItem(ImageUtils.decodeSampledBitmapFromResource(getResources(),
                    PersonUtils.femaleAvatars[1], 100, 100)));
            sliderItems.add(new SliderItem(ImageUtils.decodeSampledBitmapFromResource(getResources(),
                    PersonUtils.femaleAvatars[0], 100, 100)));
        }
        binding.viewPagerImageSlider.setAdapter(new SliderAdapter(sliderItems, binding.viewPagerImageSlider));
        binding.viewPagerImageSlider.setClipToPadding(false);
        binding.viewPagerImageSlider.setClipChildren(false);
        binding.viewPagerImageSlider.setOffscreenPageLimit(3);
        binding.viewPagerImageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        binding.viewPagerImageSlider.setPageTransformer(compositePageTransformer);

        binding.viewPagerImageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(NewGameInputFragment.getGender().equals("male")) {
                    avatar = PersonUtils.maleAvatars[position];
                } else avatar = PersonUtils.femaleAvatars[position];
            }
        });

        binding.putNewAvatarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("avatar", avatar);
                getParentFragmentManager().setFragmentResult("requestKey", bundle);
                getFragmentManager().popBackStackImmediate();
            }
        });

        return binding.getRoot();
    }

    public static int getAvatar() {
        return avatar;
    }
}