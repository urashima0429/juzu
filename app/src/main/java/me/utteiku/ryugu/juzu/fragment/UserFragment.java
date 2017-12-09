package me.utteiku.ryugu.juzu.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.databinding.FragmentUserBinding;
import me.utteiku.ryugu.juzu.model.User;
import me.utteiku.ryugu.juzu.service.MarketServiceHolder;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ryugu on 2017/08/21.
 */

public class UserFragment extends Fragment {
 
    private FragmentUserBinding fragmentUserBinding;
    //private static final String ARGS_CATEGORY_ID = "friend_id";

    public static UserFragment newInstance(int userId) {
        UserFragment fragment = new UserFragment();
        Bundle bundle = new Bundle();
        //bundle.putString(ARGS_CATEGORY_ID, userId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Bundle args = getArguments();
        //categoryId = args.getString(ARGS_CATEGORY_ID);

        fragmentUserBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
        MarketServiceHolder.get()
                .users()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<User>>() {
                    @Override
                    public void call(List<User> users) {
                        for (User user : users) {
                            fragmentUserBinding.userName.setText(user.getName());
                            fragmentUserBinding.userAge.setText("Age:" + String.valueOf(user.getAge()));
                            fragmentUserBinding.userGender.setText(user.getGender().getValue());
                            fragmentUserBinding.userPoint.setText("point:" + user.getPoint());
                            fragmentUserBinding.userIntroduce.setText(user.getIntroduction());
                        }
                    }
                    //onError
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT);
                    }
                });
        return fragmentUserBinding.getRoot();
    }
}
