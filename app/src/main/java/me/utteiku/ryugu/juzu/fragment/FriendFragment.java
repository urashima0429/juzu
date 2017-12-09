package me.utteiku.ryugu.juzu.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import me.utteiku.ryugu.juzu.Gender;
import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.adapter.FriendAdapter;
import me.utteiku.ryugu.juzu.databinding.FragmentFriendBinding;
import me.utteiku.ryugu.juzu.model.Friend;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

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

        final FriendAdapter adapter = new FriendAdapter();
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
//        list.add(new Friend(2, "second", 30, Gender.female, "転職先探してるエンジニアです", "second@example.com"));
//        list.add(new Friend(3, "third", 18,Gender.other, "誰でもござれ", "third@example.com"));
//        list.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
//        list.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
//        list.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
//        list.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
//        list.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
//        list.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
//        list.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
//        list.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
//        list.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
//        list.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
//        list.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
//        list.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
//        list.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
//        list.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
//        list.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));
//        list.add(new Friend(1, "first", 20, Gender.male, "恋人", "first@example.com"));
//        list.add(new Friend(2, "second", 30, Gender.female, "仕事", "second@example.com"));
//        list.add(new Friend(3, "third", 18,Gender.other, "特にないよ", "third@example.com"));


        // TODO: 2017/10/24 非同期処理
//        FetchFriends() // オススメ一覧を取得するapi経由で取得するobservable
//                .subscribeOn(Schedulers.io()) // 処理全体をワーカースレッドで実行する
//                .observeOn(AndroidSchedulers.mainThread()) // ここより下の処理をuiスレッドで実行する。
//                .subscribe(new Action1<List<Friend>>(){
//                    @Override
//                    public void call(List<Friend> items) {
//                        // uiスレッドで値を受け取ってrecyclerviewを更新する。
//                        adapter.addAll(items);
//                        adapter.notifyDataSetChanged();
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        // 例外時の処理を記述
//                    }
//                });

        adapter.notifyDataSetChanged();
        return binding.getRoot();

    }

}
