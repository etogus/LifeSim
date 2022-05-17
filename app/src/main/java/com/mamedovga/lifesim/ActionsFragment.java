package com.mamedovga.lifesim;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mamedovga.lifesim.databinding.FragmentActionsBinding;
import com.mamedovga.lifesim.databinding.FragmentRelationshipsBinding;
import com.mamedovga.lifesim.models.BasicAction;
import com.mamedovga.lifesim.models.NonPlayableCharacter;
import com.mamedovga.lifesim.models.StatusAction;
import com.mamedovga.lifesim.utils.PersonUtils;

import java.util.ArrayList;

public class ActionsFragment extends Fragment implements ActionsRecyclerViewAdapter.ItemClickListener, StatusActionsAdapter.ItemClickListener {

    private FragmentActionsBinding binding;
    private ArrayList<BasicAction> list = new ArrayList<>();
    public static StatusActionsAdapter statusActionsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentActionsBinding.inflate(inflater, container, false);
        buildList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        binding.recyclerViewActions.setLayoutManager(linearLayoutManager);
        ActionsRecyclerViewAdapter recyclerViewAdapter = new ActionsRecyclerViewAdapter(list, this);
        binding.recyclerViewActions.setAdapter(recyclerViewAdapter);

        LinearLayoutManager linearLayoutManagerStatus = new LinearLayoutManager(requireActivity());
        binding.recyclerViewStatusActions.setLayoutManager(linearLayoutManagerStatus);
        statusActionsAdapter = new StatusActionsAdapter(GameActivity.statusActions, this);
        binding.recyclerViewStatusActions.setAdapter(statusActionsAdapter);

        return binding.getRoot();
    }

    private void buildList() {
        BasicAction gym = new BasicAction(R.drawable.gym, "Сходить в спортзал",
                "В здоровем теле - здоровый дух!", "gym", 30);
        BasicAction movie = new BasicAction(R.drawable.movie, "Посмотреть фильм",
                "Улучшает настроение", "movie", 5);
        BasicAction book = new BasicAction(R.drawable.book, "Почитать книгу",
                "Улучшает настроение и интеллект", "book", 5);
        BasicAction game = new BasicAction(R.drawable.game, "Поиграть в игру",
                "А ты точно сделал все уроки?", "game", 5);
        BasicAction doctor = new BasicAction(R.drawable.doctor, "Сходить к врачу",
                "Лечит травмы и болезни", "doctor", 5);
        list.add(gym);
        list.add(movie);
        list.add(book);
        list.add(game);
        list.add(doctor);
    }

    @Override
    public void onItemClick(BasicAction basicAction) {
        ActionDialogFragment dialog = ActionDialogFragment.newInstance(basicAction.getImage(), basicAction.getEnergy(), basicAction.getLabel(), basicAction.getName());
        dialog.setTargetFragment(ActionsFragment.this, 1);
        dialog.show(getActivity().getSupportFragmentManager(), "ActionDialog");
    }

    @Override
    public void onItemClick(StatusAction statusAction) {
        Toast.makeText(requireContext(), "Нажал!", Toast.LENGTH_SHORT).show();
    }
}