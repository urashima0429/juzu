package me.utteiku.ryugu.juzu.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.adapter.NotificationAdapter;
import me.utteiku.ryugu.juzu.databinding.FragmentNotificationBinding;
import me.utteiku.ryugu.juzu.model.Notification;

/**
 * Created by ryugu on 2017/08/23.
 */

public class NotificationFragment extends Fragment {

    private FragmentNotificationBinding binding;

    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Bundle args = getArguments();
        //categoryId = args.getString(ARGS_CATEGORY_ID);

        NotificationAdapter adapter = new NotificationAdapter();
        adapter.setClickListener(new NotificationAdapter.ClickListener(){
            @Override
            public void onClickItem(Notification notification, View view){
                Toast.makeText(getActivity(), "tapped", Toast.LENGTH_SHORT).show();
            }
        });
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.add(new Notification(1, 1));
        adapter.add(new Notification(2, 1));
        adapter.add(new Notification(3, 1));
        adapter.add(new Notification(4, 1));
        adapter.add(new Notification(5, 1));
        adapter.add(new Notification(6, 1));
        adapter.add(new Notification(7, 1));
        adapter.add(new Notification(8, 1));
        adapter.add(new Notification(9, 1));
        adapter.add(new Notification(10, 1));
        adapter.add(new Notification(11, 1));
        adapter.add(new Notification(12, 1));
        adapter.add(new Notification(13, 1));
        adapter.add(new Notification(14, 1));
        adapter.add(new Notification(15, 1));
        adapter.add(new Notification(16, 1));
        adapter.add(new Notification(17, 1));


        adapter.notifyDataSetChanged();
        return binding.getRoot();
    }

}

