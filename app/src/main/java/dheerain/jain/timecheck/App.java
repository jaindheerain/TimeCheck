package dheerain.jain.timecheck;

import android.app.Application;

/**
 * Created by Dheerain on 27-08-2017.
 */

public class App extends Application {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App getApp(){
        return app;
    }

}
