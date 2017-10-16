package me.utteiku.ryugu.juzu.activity;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.fragment.FriendFragment;
import me.utteiku.ryugu.juzu.fragment.NotificationFragment;
import me.utteiku.ryugu.juzu.fragment.UserFragment;
import me.utteiku.ryugu.juzu.model.Notification;
import me.utteiku.ryugu.juzu.model.User;

public class MainActivity extends AppCompatActivity {

    private int prevItemId;
    private Bundle bundle = new Bundle();
    private FragmentManager fragmentManager = getFragmentManager();


    private static String EXTRA_ITEM_ID = "extra_item_id";
    public static Intent createIntent(Context context, int itemId) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_ITEM_ID, itemId);
        return intent;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id = item.getItemId();
            if(prevItemId != id) {
                prevItemId = id;
                switch (id) {
                    case R.id.navigation_friend:
                        fragmentTransaction(FriendFragment.newInstance(0));
                        return true;

                    case R.id.navigation_dashboard:
                        return true;

                    case R.id.navigation_notifications:
                        fragmentTransaction(NotificationFragment.newInstance());
                        return true;

                    case R.id.navigation_pref:
                        fragmentTransaction(UserFragment.newInstance(0));
                        return true;
                }
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
        prevItemId = R.id.navigation_friend;
        fragmentTransaction(FriendFragment.newInstance(0));
    }

    private void fragmentTransaction(Fragment fragment){
            bundle.clear();
            fragment.setArguments(bundle);
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
    }
}
