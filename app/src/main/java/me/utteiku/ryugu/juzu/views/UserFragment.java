package me.utteiku.ryugu.juzu.views;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import me.utteiku.ryugu.juzu.Gender;
import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.databinding.FragmentUserBinding;
import me.utteiku.ryugu.juzu.manager.UserManager;
import me.utteiku.ryugu.juzu.model.User;
import me.utteiku.ryugu.juzu.api.MarketServiceHolder;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ryugu on 2017/08/21.
 */

public class UserFragment extends Fragment {

    private UserManager userManager;
    private FragmentUserBinding fragmentUserBinding;

    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        userManager = UserManager.getInstance();

        if (userManager.isRegistered()) {
            fragmentUserBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
            fragmentUserBinding.userName.setText(userManager.getUsername());
            fragmentUserBinding.userAge.setText("Age:" + String.valueOf(0));
            fragmentUserBinding.userGender.setText("Gender:" + Gender.other.getValue());
            fragmentUserBinding.userPoint.setText("point:"+ 0);
            fragmentUserBinding.userIntroduce.setText(null);
            return fragmentUserBinding.getRoot();

//        MarketServiceHolder.get()
//                .users()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<List<User>>() {
//                    @Override
//                    public void call(List<User> users) {
//                        for (User user : users) {
//                            fragmentUserBinding.userName.setText(user.name);
//                            fragmentUserBinding.userAge.setText("Age:" + String.valueOf(user.age));
//                            fragmentUserBinding.userGender.setText(user.gender.getValue());
//                            fragmentUserBinding.userPoint.setText("point:" + user.point);
//                            fragmentUserBinding.userIntroduce.setText(user.introduction);
//                        }
//                    }
//                    //onError
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT);
//                    }
//                });
        } else {
            return  null;
        }
    }
}
