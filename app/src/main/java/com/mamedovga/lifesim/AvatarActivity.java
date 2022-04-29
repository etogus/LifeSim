package com.mamedovga.lifesim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mamedovga.lifesim.models.MainCharacterViewModel;
import com.mamedovga.lifesim.utils.PersonUtils;

import java.util.ArrayList;
import java.util.List;

public class AvatarActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private MainCharacterViewModel mainCharacterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);
        viewPager2 = findViewById(R.id.viewPagerImageSlider);
        List<SliderItem> sliderItems = new ArrayList<>();
        mainCharacterViewModel = ViewModelProviders.of(this).get(MainCharacterViewModel.class);
        Log.e("AvatarActivity", "gender = " + mainCharacterViewModel.getGender().getValue());
        if(mainCharacterViewModel.getGender().getValue().equals("male")) {
            sliderItems.add(new SliderItem(PersonUtils.maleAvatars[0]));
            sliderItems.add(new SliderItem(PersonUtils.maleAvatars[1]));
        } else {
            sliderItems.add(new SliderItem(PersonUtils.femaleAvatars[0]));
            sliderItems.add(new SliderItem(PersonUtils.femaleAvatars[1]));
            sliderItems.add(new SliderItem(PersonUtils.femaleAvatars[2]));
        }
        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(mainCharacterViewModel.getGender().getValue().equals("male")) {
                    mainCharacterViewModel.setAvatar(PersonUtils.maleAvatars[position]);
                } else mainCharacterViewModel.setAvatar(PersonUtils.femaleAvatars[position]);
            }
        });

        findViewById(R.id.start_game).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), GameActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}