package me.utteiku.ryugu.juzu.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.utteiku.ryugu.juzu.Gender;
import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.adapter.FriendAdapter;
import me.utteiku.ryugu.juzu.databinding.FragmentFriendBinding;
import me.utteiku.ryugu.juzu.model.Person;

/**
 * Created by ryugu on 2017/08/20.
 */

public class FriendFragment extends Fragment {

    private FragmentFriendBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FriendAdapter adapter = new FriendAdapter();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_friend, container, false);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.add(new Person(1, "first", 20, Gender.male, "恋人募集中です！よろしくおねがいします！！", "first@example.com"));
        adapter.add(new Person(2, "second", 30, Gender.female, "転職先探してるエンジニアです", "second@example.com"));
        adapter.add(new Person(3, "third", 18,Gender.other, "誰でもござれ", "third@example.com"));
        adapter.add(new Person(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Person(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Person(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Person(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Person(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Person(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Person(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Person(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Person(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Person(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Person(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Person(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Person(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Person(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Person(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Person(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Person(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Person(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));

        adapter.notifyDataSetChanged();

        return binding.getRoot();

    }

}
