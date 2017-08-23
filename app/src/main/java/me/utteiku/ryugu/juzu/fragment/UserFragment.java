package me.utteiku.ryugu.juzu.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.utteiku.ryugu.juzu.Gender;
import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.databinding.FragmentUserBinding;
import me.utteiku.ryugu.juzu.model.User;

/**
 * Created by ryugu on 2017/08/21.
 */

public class UserFragment extends Fragment {
 
    private FragmentUserBinding fragmentUserBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        User user = new User(1, "first", 20, Gender.male, 1000, false, "恋人募集中です！よろしくおねがいします！！", "first@example.com");

        fragmentUserBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
        fragmentUserBinding.userName.setText(user.getName());
        fragmentUserBinding.userAge.setText("Age:" + String.valueOf(user.getAge()));
        fragmentUserBinding.userGender.setText(user.getGender().getValue());
        fragmentUserBinding.userPoint.setText("point:" + user.getPoint());
        fragmentUserBinding.userIntroduce.setText(user.getIntroduction());
        return fragmentUserBinding.getRoot();

    }
}
