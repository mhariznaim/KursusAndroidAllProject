package com.ftmk.mhariznaim.hellowwduniakotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class GetRandomUserApiActivity extends AppCompatActivity {

    String strURL = "https://randomuser.me/api";
    TextView txtvwfirstName, txtvwLastName,txtvwGender,txtvwTitle,txtvwStreet,txtvwPostcode,txtvwCity;
    Button btngetUser;
    ImageView imgvwRandom;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_random_user_api);

        txtvwfirstName = findViewById(R.id.txtVwRanFirstName);
        txtvwLastName = findViewById(R.id.txtVwRanLastName);
        txtvwGender = findViewById(R.id.txtVwRanGender);
        txtvwTitle = findViewById(R.id.txtVwRanTitle);
        txtvwStreet = findViewById(R.id.txtVwRanStreet);
        txtvwPostcode = findViewById(R.id.txtVwRanPostcode);
        txtvwCity = findViewById(R.id.txtVwRanCity);
        btngetUser = findViewById(R.id.btnGetData);

        imgvwRandom = findViewById(R.id.imgVwRanPerson);
        progressBar = findViewById(R.id.progBarRandom);


    }

    public void fnGetUser(View view) {
        progressBar.setVisibility(View.VISIBLE);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, strURL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                try {
                    JSONObject jsonRespon = new JSONObject(response);
                    JSONObject jsnPersonObj = jsonRespon.getJSONArray("results").getJSONObject(0);

                    txtvwfirstName.setText(jsnPersonObj.getJSONObject("name").getString("first"));
                    txtvwLastName.setText(jsnPersonObj.getJSONObject("name").getString("last"));
                    txtvwTitle.setText(jsnPersonObj.getJSONObject("name").getString("title"));
                    txtvwGender.setText(jsnPersonObj.getString("gender"));
                    txtvwStreet.setText(jsnPersonObj.getJSONObject("location").getString("street"));
                    txtvwPostcode.setText(jsnPersonObj.getJSONObject("location").getString("postcode"));
                    txtvwCity.setText(jsnPersonObj.getJSONObject("location").getString("city"));

                    String strUrlPic = jsnPersonObj.getJSONObject("picture").getString("large");
                    Glide.with(GetRandomUserApiActivity.this).load(strUrlPic).into(imgvwRandom);
                }catch (JSONException JE)
                {
                    Log.d("errr", JE.getMessage());
                }
                progressBar.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }      );
        requestQueue.add(stringRequest);
        }

    }

