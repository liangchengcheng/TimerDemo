package mddemo.library.com.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月21日16:10:06
 * Description:
 */
public class PollingService extends Service {

    public static final String ACTION = "mddemo.library.com.service.PollingService";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart(Intent intent, int startId) {
        new PollingThread().start();
    }

    int count = 0;
    class PollingThread extends Thread {
        @Override
        public void run() {
            System.out.println("Polling...");
            count ++;
            if (count % 5 == 0) {
                //做一些别的事情
                Looper.prepare();
                Toast.makeText(PollingService.this,"llll",Toast.LENGTH_SHORT).show();
               Looper.loop();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service:onDestroy");
    }

}