package com.example.robonaut4.rih_prototype;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Robonaut 4 on 07-04-2017.
 */

class HomePage {

    private LinearLayout papa;
    private TextView temperaturetextView, pulsetextView, ignoredStringtextView,tracktextView;
    private Button button;
    private MainActivity mainActivity;

    private ServerSocket socket;

    public HomePage(LinearLayout relativeLayout, MainActivity mainActivity) {
        papa = relativeLayout;
        this.mainActivity = mainActivity;

        initialize();
        setComponents();
        actionListeners();
    }

    private void initialize() {
        tracktextView = new TextView(papa.getContext());
        tracktextView.setText("ATG");

        temperaturetextView = new TextView(papa.getContext());
        temperaturetextView.setText("Temperature = value not received");

        pulsetextView = new TextView(papa.getContext());
        pulsetextView.setText("Pulse = value not received");

        ignoredStringtextView = new TextView(papa.getContext());
        ignoredStringtextView.setText("ATG");

        button = new Button(papa.getContext());
        button.setText("Click to send data");
    }

    private void setComponents() {
        papa.setOrientation(papa.VERTICAL);

        papa.addView(tracktextView);
        papa.addView(temperaturetextView);
        papa.addView(pulsetextView);
        papa.addView(ignoredStringtextView);

        papa.addView(button);
    }

    private void actionListeners() {
        getIPAddress();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listenContinuousInputdata();

            }
        });
    }

    private void listenContinuousInputdata() {

        new Thread(){
            @Override
            public void run() {

                try {
                    socket = new ServerSocket(2017);
                    Socket clientSocket = socket.accept();       //This is blocking. It will wait.

                    DataInputStream DIS = new DataInputStream(clientSocket.getInputStream());

                    while(true) {
                        String msg_received = DIS.readLine();

                        if(msg_received==null)continue;

                        if(msg_received.equals("CLOSE"))break;

                        runMsgRcvdOnMainthread(msg_received);

                    }
                    clientSocket.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void runMsgRcvdOnMainthread(final String msg_received) {
        mainActivity.runOnUiThread(new Runnable() {
            public void run() {
                //tracktextView.setText(Integer.toString(i+1));
                if(msg_received==null) return;

                if(msg_received.length()<=2)return;

                String startingString = msg_received.substring(0,2);
                String valueString = msg_received.substring(2,msg_received.length());

                if(startingString.equals("TM")){
                    temperaturetextView.setText("Temperature = " + valueString);
                }
                else if(startingString.equals("PL")){
                    pulsetextView.setText("Pulse = " + valueString);
                }
                else{
                    String s="";
                    for(int i=0;i<msg_received.length();i++)
                        s=s+(int)msg_received.charAt(i)+" ";
                    ignoredStringtextView.setText("Ignored String = "+s);
                }
            }
        });
    }

    private void getIPAddress() {
    }
}
