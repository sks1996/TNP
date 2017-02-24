package com.example.a1405264.sun;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by 1405264 on 1/15/2017.
 */

public class MyFirebaseInstanceService extends FirebaseInstanceIdService
{

    private static  final String REG_TOKEN ="REG_TOKEN";
    @Override
    public void onTokenRefresh() {

        String recent_token = FirebaseInstanceId.getInstance().getToken();
        Log.d(REG_TOKEN,recent_token);
    }
}
