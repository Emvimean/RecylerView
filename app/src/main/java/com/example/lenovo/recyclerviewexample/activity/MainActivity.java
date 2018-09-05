package com.example.lenovo.recyclerviewexample.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.recyclerviewexample.api.ExampleAdapter;
import com.example.lenovo.recyclerviewexample.enitity.ExampleItem;
import com.example.lenovo.recyclerviewexample.R;
import com.example.lenovo.recyclerviewexample.fragment.AlertDFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm=getSupportFragmentManager();
    Button b1, b2, button;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON("crator","imageUrl", "Url");

        //Testing Dialog message
        button=findViewById(R.id.button);
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDFragment alertDFragment=new AlertDFragment();
                alertDFragment.show(fm,"Hellow Dialog");
            }
        });*/

    }

    /**
     *
     */
    public void parseJSON(final String creator, final String imageUrl, String Url){
        Url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for (int i = 0; i<jsonArray.length(); i++){
                                JSONObject hit = jsonArray.getJSONObject(i);
                                String creator = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");

                                mExampleList.add(new ExampleItem(imageUrl, creator));
                            }
                            mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }

    /**
     *
     */
    public void displayItem(){
        int id;

        }
    }

