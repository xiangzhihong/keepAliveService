package xzh.com.keepaliveservice.breoadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import xzh.com.keepaliveservice.service.AliveService;

public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent startServiceIntent = new Intent(context, AliveService.class);
            startServiceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(startServiceIntent);
        }
    }
}
