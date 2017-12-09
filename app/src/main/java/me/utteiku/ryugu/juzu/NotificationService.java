package me.utteiku.ryugu.juzu;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by ryugu on 2017/10/16.
 */

public class NotificationService extends Service{
    private Handler handler = new Handler();
    private boolean running = false;
    private String message = "notification service is running";
    private String title = "juzu";

    @Override
    public void onCreate(){
        super.onCreate();
    }
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);

        Thread thread = new Thread(){
            public void run(){
                running = true;
                while (running){
                    handler.post(new Runnable(){
                        @Override
                        public void run() {
                            showNotification(getApplicationContext(), title, message);
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
        return INotificationServiceBinder;
    }

    private void showNotification(Context context, String title, String text){

        //set notification contents
        Notification.Builder builder = new Notification.Builder(context);
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(title);
        builder.setContentText(text);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        //delete notification automatically on tapped
        builder.setAutoCancel(true);

        //set intent when notification is tapped
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(new ComponentName("me.utteiku.ryugu.juzu", "me.utteiku.ryugu.juzu/.activity.mainActivity"));
        intent.removeCategory(Intent.CATEGORY_DEFAULT);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        builder.setContentIntent(PendingIntent.getActivity(
                context, 0, intent,
                PendingIntent.FLAG_CANCEL_CURRENT));

        //show notification
        NotificationManager um =
                (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        um.cancel(1);
        um.notify(1, builder.build());
    }

    //passing values for notification
    private final INotificationService.Stub INotificationServiceBinder = new INotificationService.Stub(){
        // demonstrates some basic types that you can use as parameters
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
        }
        public void setMessage(String msg) throws RemoteException {
            message = msg;
        }
    };

}
