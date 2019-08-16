package com.coffeewithandroid.volley_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.coffeewithandroid.volley_json.Network.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView txtdata;
    private Button btngetresult;
    public static String URL = "http://services.odata.org/V4/(S(mkqdgwdxd0nd1f2nuhz30r2d))/TripPinServiceRW/";
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;
    MyApplication myApplication = (MyApplication) MyApplication.getAppContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtdata = (TextView) findViewById(R.id.txtdata);
        btngetresult = (Button) findViewById(R.id.btngetresult);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        btngetresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                parseData();
            }
        });
    }

    private void parseData() {
        volleySingleton = VolleySingleton.getsInstance();
        requestQueue = VolleySingleton.getRequestQueue();
        final StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response == null || response.length() == 0) {
                    Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    String jsonArray = '[' + response.split("\\[")[1];
                    try {
                        JSONArray result = new JSONArray(jsonArray.substring(0, jsonArray.length() - 1));
                        String finaloutput = "";
                        for (int i = 0; i < result.length(); i++) {
                            JSONObject curr = result.getJSONObject(i);
                            finaloutput += "name: " + curr.getString("name") + ", " + "kind: " + curr.getString("kind") + "\n\n";

                        }
                        txtdata.setText(finaloutput);
                        progressBar.setVisibility(View.INVISIBLE);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                } else if (error instanceof NetworkError) {
                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }

                progressBar.setVisibility(View.INVISIBLE);
            }

        });
        requestQueue.add(request);
    }
}
