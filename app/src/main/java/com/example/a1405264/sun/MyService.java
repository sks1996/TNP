package com.example.a1405264.sun;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MyService extends Service {


    private DatabaseReference mdatabase;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
        //throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mdatabase = FirebaseDatabase.getInstance().getReference().child("Notification");
        mdatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //at the start of the app start atleast on start of app


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                try {

                    MainActivity.VALUE=dataSnapshot.getValue(String.class);
                    Intent NEW_NOTIFICATION=new Intent();
                    NEW_NOTIFICATION.setAction("A_NEW_NOTIFICATION");
                    sendBroadcast(NEW_NOTIFICATION);

                }catch (Exception e)
                {
                    MainActivity.VALUE="A New Notification";
                    Intent NEW_NOTIFICATION=new Intent();
                    NEW_NOTIFICATION.setAction("A_NEW_NOTIFICATION");
                    sendBroadcast(NEW_NOTIFICATION);


                }


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
