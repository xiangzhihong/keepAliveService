package xzh.com.keepaliveservice.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by xiangzhihong on 2016/4/21 on 17:21.
 */
public class AliveService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(getApplicationContext(), AliveService.class);
        AlarmManager  mAlarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        PendingIntent mPendingIntent = PendingIntent.getService(this, 0, intent, 0);
        long now = System.currentTimeMillis();
        mAlarmManager.setInexactRepeating(AlarmManager.RTC, now, 300, mPendingIntent);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Callback Successed!", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
