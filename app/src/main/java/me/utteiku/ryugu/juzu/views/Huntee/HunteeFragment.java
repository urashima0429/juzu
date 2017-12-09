package me.utteiku.ryugu.juzu.views.Huntee;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.databinding.FragmentHunteeBinding;
import me.utteiku.ryugu.juzu.model.Huntee;

/**
 * Created by ryugu on 2017/08/20.
 */

public class HunteeFragment extends Fragment {

    private FragmentHunteeBinding binding;


    //private static final String ARGS_CATEGORY_ID = "friend_id";
    public static HunteeFragment newInstance(int friendId) {
        HunteeFragment fragment = new HunteeFragment();
        Bundle bundle = new Bundle();
        //bundle.putString(ARGS_CATEGORY_ID, hunteeId);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        //Bundle args = getArguments();
        //categoryId = args.getString(ARGS_CATEGORY_ID);

        final HunteeAdapter adapter = new HunteeAdapter();
        adapter.setClickListener(new HunteeAdapter.ClickListener(){
            @Override
            public void onClickItem(Huntee huntee, View view){
                Toast.makeText(getActivity(), "tapped", Toast.LENGTH_SHORT).show();
            }
        });
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_huntee, container, false);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.add(new Huntee());


        // TODO: 2017/10/24 非同期処理
//        FetchHuntees() // オススメ一覧を取得するapi経由で取得するobservable
//                .subscribeOn(Schedulers.io()) // 処理全体をワーカースレッドで実行する
//                .observeOn(AndroidSchedulers.mainThread()) // ここより下の処理をuiスレッドで実行する。
//                .subscribe(new Action1<List<Huntee>>(){
//                    @Override
//                    public void call(List<Huntee> items) {
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
