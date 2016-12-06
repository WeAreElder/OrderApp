package com.example.orderapp1.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.example.orderapp1.MainActivity;
import com.example.orderapp1.R;
 
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
 
public class ForegroundService extends Service {
 
    private static final Class[] mStartForegroundSignature = new Class[] {
        int.class, Notification.class};
    private static final Class[] mStopForegroundSignature = new Class[] {
        boolean.class};
    private NotificationManager mNM;
    private Method mStartForeground;
    private Method mStopForeground;
    private Object[] mStartForegroundArgs = new Object[2];
    private Object[] mStopForegroundArgs = new Object[1];
     
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
     
    @Override
    public void onCreate() {
        super.onCreate();
        mNM = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        try {
            mStartForeground = ForegroundService.class.getMethod("startForeground", mStartForegroundSignature);
            mStopForeground = ForegroundService.class.getMethod("stopForeground", mStopForegroundSignature);
        } catch (NoSuchMethodException e) {
            mStartForeground = mStopForeground = null;
        }
         // ���ǲ�����ҪΪ notification.flags ���� FLAG_ONGOING_EVENT����Ϊ
         // ǰ̨����� notification.flags ����Ĭ�ϰ������Ǹ���־λ
        Notification notification = new Notification(R.drawable.ic_launcher, "Foreground Service Started.",
                System.currentTimeMillis());
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);
        notification.setLatestEventInfo(this, "Foreground Service",
                "Foreground Service Started.", contentIntent);
        // ע��ʹ��  startForeground ��id Ϊ 0 ��������ʾ notification
        startForegroundCompat(1, notification);
    }
     
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForegroundCompat(1);
    }
     
    // �Լ����Է�ʽ��ʼǰ̨����
    private void startForegroundCompat(int id, Notification n){
        if(mStartForeground != null){
            mStartForegroundArgs[0] = id;
            mStartForegroundArgs[1] = n;
             
            try {
                mStartForeground.invoke(this, mStartForegroundArgs);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
             
            return;
        }
        stopForeground(false);
        mNM.notify(id, n);
    }
     
    // �Լ����Է�ʽֹͣǰ̨����
    private void stopForegroundCompat(int id){
        if(mStopForeground != null){
            mStopForegroundArgs[0] = Boolean.TRUE;
             
            try {
                mStopForeground.invoke(this, mStopForegroundArgs);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return;
        }
         
        //  �� setForeground ֮ǰ���� cancel����Ϊ�����п�����ȡ��ǰ̨����֮��
        //  ����һ˲�䱻kill�������ʱ�� notification ����Զ�����֪ͨһ���Ƴ�
        mNM.cancel(id);
        stopForeground(true);
    }
 
}