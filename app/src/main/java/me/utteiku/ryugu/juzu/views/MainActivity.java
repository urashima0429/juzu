package me.utteiku.ryugu.juzu.views;


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
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.List;

import me.utteiku.ryugu.juzu.INotificationService;
import me.utteiku.ryugu.juzu.notification.NotificationService;
import me.utteiku.ryugu.juzu.R;
import me.utteiku.ryugu.juzu.views.Huntee.HunteeFragment;

public class MainActivity extends AppCompatActivity {

    private int prevItemId;
    private Bundle bundle = new Bundle();
    private FragmentManager fragmentManager = getFragmentManager();
    private INotificationService binder;
    private Intent serviceIntent;

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    //notification service connection
    private ServiceConnection notificationServiceConnection = new ServiceConnection(){
        public void onServiceConnected(ComponentName name, IBinder service){
            binder = INotificationService.Stub.asInterface(service);
        }
        public void onServiceDisconnected(ComponentName name){
            binder = null;
        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id = item.getItemId();
            if(prevItemId != id) {
                prevItemId = id;
                switch (id) {
                    case R.id.navigation_home:
                        return true;

                    case R.id.navigation_huntee:
                        fragmentTransaction(HunteeFragment.newInstance(0));
                        return true;

                    case R.id.navigation_notifications:
                        fragmentTransaction(NotificationFragment.newInstance());
                        return true;

                    case R.id.navigation_pref:
                        fragmentTransaction(UserFragment.newInstance());
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
        prevItemId = R.id.navigation_huntee;
        fragmentTransaction(UserFragment.newInstance());

        //start notification service
        serviceIntent = new Intent(this, NotificationService.class);
        if(isServiceRunning("me.utteiku.ryugu.juzu/.NotificationService")) {
            bindService(serviceIntent, notificationServiceConnection, BIND_AUTO_CREATE);
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

    private void setNotificationServiceMassage(String msg) {
        try {
            binder.setMessage(msg);
        } catch (RemoteException e) {

        }
    }
}
