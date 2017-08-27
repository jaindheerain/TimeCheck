package dheerain.jain.timecheck;

import android.app.AppOpsManager;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

import static android.app.AppOpsManager.MODE_ALLOWED;
import static android.app.AppOpsManager.OPSTR_GET_USAGE_STATS;
import static android.os.Process.myUid;

public class MainActivity extends AppCompatActivity {

    UsageStatsManager usageStatsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!checkForPermission(getApplicationContext())){
            startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
        }else{
            usageStatsManager = (UsageStatsManager) getApplicationContext().getSystemService(Context.USAGE_STATS_SERVICE);
        }
    }


    private boolean checkForPermission(Context context) {
        AppOpsManager appOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(OPSTR_GET_USAGE_STATS, myUid(), context.getPackageName());
        return mode == MODE_ALLOWED;
    }

}



