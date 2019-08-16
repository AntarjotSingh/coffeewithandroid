package com.coffeewithandroid.volley_json.Network;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.coffeewithandroid.volley_json.MyApplication;

public class VolleySingleton {

    private static VolleySingleton sInstance = null;
    private static RequestQueue mRequestQueue;
    private VolleySingleton(){
        mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static VolleySingleton getsInstance(){
        if(sInstance == null)
        {
            sInstance = new VolleySingleton();
        }
        return sInstance;
    }

    public static RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
}
