package me.utteiku.ryugu.juzu;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

/**
 * Created by ryugu on 2017/10/16.
 */

public class MyService extends Service{
    private Handler handler = new Handler();
    private boolean running = false;
    private String message = "Message";

    @Override
    public void onCreate(){
        super.onCreate();
    }
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);

        showNotification(this, "HelloWorld", "controll HelloWorld");

        Thread thread = new Thread(){
            public void run(){
                running = true;
                while (running){
                    handler.post(new Runnable(){
                        @Override
                        public void run() {
                            toast(MyService.this, message);
                        }
                    });

                    try {
                        Thread.sleep(30000);
                    }catch (Exception e){}
                }
            }};
        thread.start();
        return START_NOT_STICKY;
    }
    @Override
    public void onDestroy(){
        running = false;
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent){
        return IMyServiceBinder;
    }

    private void showNotification(Context context, String title, String text){

        Notification.Builder builder = new Notification.Builder(context);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle(title);
        builder.setContentText(text);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(new ComponentName("me.utteiku.ryugu.juzu", "me.utteiku.ryugu.juzu/.activity.mainActivity"));
        intent.removeCategory(Intent.CATEGORY_DEFAULT);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        builder.setContentIntent(PendingIntent.getActivity(
                context, 0, intent,
                PendingIntent.FLAG_CANCEL_CURRENT));

        NotificationManager um =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        um.cancel(1);
        um.notify(1, builder.build());
    }

    private void toast(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
    private final IMyService.Stub IMyServiceBinder = new IMyService.Stub(){
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
        }

        public void setMessage(String msg) throws RemoteException {
            message = msg;
        }
    };


}
