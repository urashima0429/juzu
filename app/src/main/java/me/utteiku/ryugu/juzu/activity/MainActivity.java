package me.utteiku.ryugu.juzu.activity;


import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;



import java.util.List;

import me.utteiku.ryugu.juzu.IMyService;
import me.utteiku.ryugu.juzu.NotificationService;
import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.fragment.FriendFragment;
import me.utteiku.ryugu.juzu.fragment.NotificationFragment;
import me.utteiku.ryugu.juzu.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    private int prevItemId;
    private Bundle bundle = new Bundle();
    private FragmentManager fragmentManager = getFragmentManager();
    private IMyService binder;
    private Intent serviceIntent;

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
        fragmentTransaction(UserFragment.newInstance(0));

        //service
        serviceIntent = new Intent(this, NotificationService.class);
        if(isServiceRunning("me.utteiku.ryugu.juzu/.NotificationService")) {
            bindService(serviceIntent, connection, BIND_AUTO_CREATE);
        }
        startService(serviceIntent);
    }

    private void fragmentTransaction(Fragment fragment){
            bundle.clear();
            fragment.setArguments(bundle);
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
    }

    private boolean isServiceRunning(String classname){
        ActivityManager am = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceInfos = am.getRunningServices((Integer.MAX_VALUE));
        for (int i = 0; i < serviceInfos.size(); i++){
            if(serviceInfos.get(i).service.getClassName().equals(classname)){
                return true;
            }
        }
        return false;
    }

    private ServiceConnection connection = new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder service){
            binder = IMyService.Stub.asInterface(service);
        }

        public void onServiceDisconnected(ComponentName name){
            binder = null;
        }
    };

}
