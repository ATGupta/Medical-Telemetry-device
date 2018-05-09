package com.example.robonaut4.rih_prototype;


import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WifiDirectBroadcastReceiver extends AsyncTask<Void,Void,Void> {

    private TextView textView;
    private Socket socket;
    private PrintWriter printWriter;

    public WifiDirectBroadcastReceiver(TextView textView){
        this.textView = textView;
        doInBackground();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        return null;
    }
}
/*import android.content.BroadcastReceiver;
import android.net.wifi.p2p.WifiP2pManager;

/**
 * Created by Robonaut 4 on 07-04-2017.
 //* /

public class WiFiDirectBroadcastReceiver extends BroadcastReceiver {

    private WifiP2pManager mManager;
    private Channel mChannel;
    private MyWiFiActivity mActivity;

    public WiFiDirectBroadcastReceiver(WifiP2pManager manager, Channel channel,
                                       MyWifiActivity activity) {
        super();
        this.mManager = manager;
        this.mChannel = channel;
        this.mActivity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            // Check to see if Wi-Fi is enabled and notify appropriate activity
        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
            // Call WifiP2pManager.requestPeers() to get a list of current peers
        } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
            // Respond to new connection or disconnections
        } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
            // Respond to this device's wifi state changing
        }
    }
}*/