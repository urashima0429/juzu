package me.utteiku.ryugu.juzu.activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.fragment.FriendFragment;
import me.utteiku.ryugu.juzu.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Bundle bundle = new Bundle();
    private FragmentManager fragmentManager = getFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_friend:

                    bundle.clear();
                    FriendFragment friendFragment = new FriendFragment();
                    friendFragment.setArguments(bundle);
                    FragmentTransaction transaction_friend = fragmentManager.beginTransaction();
                    transaction_friend.replace(R.id.content, friendFragment);
                    transaction_friend.addToBackStack(null);
                    transaction_friend.commit();
                    return true;

                case R.id.navigation_dashboard:
                    return true;

                case R.id.navigation_notifications:
                    return true;

                case R.id.navigation_pref:

                    bundle.clear();
                    UserFragment userFragment = new UserFragment();
                    userFragment.setArguments(bundle);
                    FragmentTransaction transaction_user = fragmentManager.beginTransaction();
                    transaction_user.replace(R.id.content, userFragment);
                    transaction_user.addToBackStack(null);
                    transaction_user.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
