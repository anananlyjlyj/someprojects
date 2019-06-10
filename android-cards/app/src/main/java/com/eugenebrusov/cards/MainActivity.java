package com.eugenebrusov.cards;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
/*import kotlinx.android.synthetic.main.activity_main.recycler_view*/
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.eugenebrusov.cards.R;
import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EventAdapter adapter;
    Button button;
    List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("entry", "called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String URL = "http://192.168.173.206:5002/dates/2019-05-14";

        RequestQueue requestQueue=Volley.newRequestQueue(this);

        JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        // display response
                        Log.d("Response", response.toString());

                        try {
                            for(int i=0;i<response.length();i++){
                                JSONObject jresponse = response.getJSONObject(i);
                                eventList.add(
                                        new Event(
                                                jresponse.getString("title"),
                                                jresponse.getString("place"),
                                                jresponse.getInt("price"),
                                                jresponse.getString("time"),
                                                R.drawable.page3)
                                );
                                adapter = new EventAdapter(MainActivity.this, eventList);
                                recyclerView.setAdapter(adapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }

        );

        requestQueue.add(objectRequest);

        /*
        button = findViewById(R.id.price);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // SET IS MARKED TO 1-VALUE!
                //do something when clicked on
                //Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), InformationActivity.class);
                // FILL DATA!!!!
                view.getContext().startActivity(intent);
            }
        });
        */

    }
  //  public void cardOnClick(MenuItem item){
  //      Log.d("MenuItem", "test");
   // }




}
