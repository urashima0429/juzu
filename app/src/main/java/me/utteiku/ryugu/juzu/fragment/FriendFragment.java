package me.utteiku.ryugu.juzu.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.utteiku.ryugu.juzu.Gender;
import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.adapter.FriendAdapter;
import me.utteiku.ryugu.juzu.databinding.FragmentFriendBinding;
import me.utteiku.ryugu.juzu.model.Friend;

/**
 * Created by ryugu on 2017/08/20.
 */

public class FriendFragment extends Fragment {

    private FragmentFriendBinding binding;


    //private static final String ARGS_CATEGORY_ID = "friend_id";
    public static FriendFragment newInstance(int friendId) {
        FriendFragment fragment = new FriendFragment();
        Bundle bundle = new Bundle();
        //bundle.putString(ARGS_CATEGORY_ID, friendId);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        //Bundle args = getArguments();
        //categoryId = args.getString(ARGS_CATEGORY_ID);

        FriendAdapter adapter = new FriendAdapter();
        adapter.setClickListener(new FriendAdapter.ClickListener(){
            @Override
            public void onClickItem(Friend friend, View view){
                Toast.makeText(getActivity(), "tapped", Toast.LENGTH_SHORT).show();

            }
        });
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_friend, container, false);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.add(new Friend(1, "first", 20, Gender.male, "恋人募集中です！よろしくおねがいします！！", "first@example.com"));
        adapter.add(new Friend(2, "second", 30, Gender.female, "転職先探してるエンジニアです", "second@example.com"));
        adapter.add(new Friend(3, "third", 18,Gender.other, "誰でもござれ", "third@example.com"));
        adapter.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
        adapter.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
        adapter.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
        adapter.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));

        adapter.notifyDataSetChanged();

        return binding.getRoot();

    }

}
