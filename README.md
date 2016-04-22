# keepAliveService
android不死服务

原理，不断的监听系统的广播
如下，通过监听系统启动，去发送一个服务
写个BroadcastReceiver：

public class PushReceiver extends BroadcastReceiver {  
  
    @Override  
    public void onReceive(Context context, Intent intent) {  
         if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent startServiceIntent = new Intent(context, AliveService.class);
            startServiceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(startServiceIntent);
        }
    }  
}  

然后在配置文件注册下就好了
 <service android:name=".service.AliveService" />
        <receiver android:name=".breoadcast.BootBroadcastReceiver">
            <intent-filter>
                <action android:name="android.intent.action.BOOT_COMPLETED"></action>
                <action android:name="android.intent.action.USER_PRESENT" />
            </intent-filter>
        </receiver>
